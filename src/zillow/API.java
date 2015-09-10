package zillow;


public class API {
	
	// API Parameters
	static String apiHeader = "http://www.zillow.com/webservice/GetSearchResults.htm?";
	static String zwsID = "zws-id=X1-ZWz1b0j5f2l72j_9hc6e";
	static String rentZestimate = "rentzestimate=true";	
	static String apiCall;

	public static String generateCall(Property property){
		// Find spaces in street and replace with correct delimiters
		int[] spacePos = new int[10];
		for(int i = 0; i < spacePos.length; i++){
			spacePos[i] = 0;
		}
		for(int i = 0; i < spacePos.length; i++){
			int index = property.getStreet().indexOf(" ", spacePos[spacePos[0]] + 1);			
			if(index == -1)
				break;
			else{
				spacePos[0]++;
				spacePos[spacePos[0]] = index;
			}
		}
		String newStreet = "";		
		for(int i = spacePos[0]; i > 0; i--){
			if(i == 1){			
				if(spacePos[0] == 1){
					newStreet = property.getStreet().substring(0, spacePos[i]) + "-" + property.getStreet().substring(spacePos[i] + 1, property.getStreet().length()) + newStreet;
					break;
				}
				newStreet = property.getStreet().substring(0, spacePos[i]) + "-" + newStreet;
			}
			else if(i == spacePos[0]){
				newStreet = property.getStreet().substring(spacePos[i-1]+1, spacePos[i]) + "+" + property.getStreet().substring(spacePos[i] + 1, property.getStreet().length()) + newStreet;
			}
			else{
				newStreet = property.getStreet().substring(spacePos[i-1]+1, spacePos[i]) + "-" + newStreet;
			}
		}
						
		String fullAddress = "address=" + property.getNumber()+ "+" + newStreet + "+" + "&citystatezip=";
		
		fullAddress += property.getZip();		
				
		apiCall = apiHeader + zwsID + "&" + fullAddress + "&" + rentZestimate;
		
		//System.out.println("Your finalized API call:");
		//System.out.println(apiCall);
		
		return apiCall;		
		
	}

	/**
	 * This method elicits address information via the 
	 * console and uses it to generate an API call 
	 * @return
	 */
	public static String generateCall(){
		
		String number = Input.getString("Street Number");
		String street = Input.getString("Street");
		String city = Input.getString("City");
		String state = Input.getString("State");
		String zip = Input.getString("Zip");
		Property thisProperty = new Property(number, street, city, state, zip);
		
		return generateCall(thisProperty);
		
	}

	
}
