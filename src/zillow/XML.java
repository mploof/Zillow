package zillow;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class XML {
	
	public static void getXMLFromAPICall(String call, String xmlPath){
		URL url = null;
		URLConnection conn = null;
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = null;
		Document doc = null;
		TransformerFactory docFactory = TransformerFactory.newInstance();
		Transformer xform = null;
		
		try {
			url = new URL(call);
			conn = url.openConnection();
			builder = factory.newDocumentBuilder();
			doc = builder.parse(conn.getInputStream());
			xform = docFactory.newTransformer();
			File myOutput = new File(xmlPath);
			xform.transform(new DOMSource(doc), new StreamResult(myOutput));
		} 
		
		catch (MalformedURLException e) {		
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		}
	}

	public static Property read(String xmlPath, Property property) {
		
		int priceLow = 0;
		int priceEstimate = 0;
		int priceHigh = 0;
		int rentLow = 0;
		int rentEstimate = 0;
		int rentHigh = 0;
		
		try {
			
			File fXmlFile = new File(xmlPath);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			doc.getDocumentElement().normalize();
						
			Node nNode;
						
			nNode = doc.getElementsByTagName("zestimate").item(0);
					
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		
				Element eElement = (Element) nNode;			
				
				priceEstimate =  Integer.parseInt(eElement.getElementsByTagName("amount").item(0).getTextContent());
				priceLow =  Integer.parseInt(eElement.getElementsByTagName("low").item(0).getTextContent());
				priceHigh =  Integer.parseInt(eElement.getElementsByTagName("high").item(0).getTextContent());
			}
			
			nNode = doc.getElementsByTagName("rentzestimate").item(0);			
		
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		
				Element eElement = (Element) nNode;			
				
				rentEstimate = Integer.parseInt(eElement.getElementsByTagName("amount").item(0).getTextContent());
				rentLow = Integer.parseInt(eElement.getElementsByTagName("low").item(0).getTextContent());
				rentHigh = Integer.parseInt(eElement.getElementsByTagName("high").item(0).getTextContent());	
			}
			System.out.println("Done reading " + property.getFullAddress());
	    } 
		catch (Exception e) {
			System.out.println("No info for " + property.getFullAddress());
			//e.printStackTrace();
		}
		
		property.setValues(priceLow, priceEstimate, priceHigh, rentLow, rentEstimate, rentHigh);
		
		return property;
	}
}
