package zillow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {
	
	public static String getString(String prompt){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print(prompt + ": ");
		String s;
		try {
			s = br.readLine();
		} catch (IOException e) {			
			s = "Failed to read string!";
			e.printStackTrace();
		}		
		return s;
	}
	
	public static int getInt(String prompt) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print(prompt + ": ");
		try{
            int i = Integer.parseInt(br.readLine());
            return i;
        }catch(NumberFormatException nfe){
            System.err.println("Invalid Format!");
            return -1;
        }
	}   
}

