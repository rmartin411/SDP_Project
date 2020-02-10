package NonPrincipledDesign;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class RegisterBankClient {
	
	public static void ProvideUserDetails() throws ParseException {
		
		System.out.println("\n\n===Client registration===\n");
		
		String name = read("name");	
		String address = read("address");		
		String DoB = read("date of birth (DD/MM/YYYY)");		
		
		String username = read("username");
		String password = read("password");
		
		String password2 = read("password again");
		
		
		boolean checked = checkRegistrationStructure(name, address, DoB, username, password, password2);
		
		executeRegistrationTransaction()
		
		
	}
	
	public static boolean checkRegistrationStructure(String name, String address, String DoB, String username, String password, String password2) throws ParseException {
		
		boolean structure = false;
		
		if (name != null && address != null && DoB != null & username != null & password != null && password2 != null) {
			if (name.isEmpty() == false && address.isEmpty() == false && DoB.isEmpty() == false & username.isEmpty() == false & password.isEmpty() == false && password2.isEmpty() == false)
				if (password.equals(password2)) {
					
					return true;
					

					
				}
				else {
					System.out.println("Passwords do not match");
				}
			}
	
		else {
			System.out.println("Please fill out all fields");
		}
		
		return false;
	}
			
	
	public static String read( String label ) {

		System.out.println( "\nProvide your " + label + ":" );

		System.out.println( ">" );


		BufferedReader input = new BufferedReader( new InputStreamReader( System.in ) );

		String value = null;

		try {

			value = input.readLine();
		}

		catch (IOException ex) { ex.printStackTrace(); }


		return value;
	}

}
