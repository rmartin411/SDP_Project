package AllFR_OCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.List;

//import exampleGroupProject.principledDesign.principles.SRP.FR1_SRP.StdInput;



public class RegisterClientTransaction  {
	
	/*
	 * private String name; private String address; private String DoB;
	 */
	private String username;
	private String password;
	private String password2;
	
	
	public void registerNewClient(List<BankClient> clients) throws ParseException {
		
		provideRegistrationDetails();
		
		String error = checkTransactionStructure();
		
		if( error != null ) printErrorMessage( error );

		else executeRegistrationTransaction( clients );
		
	}

	private void provideRegistrationDetails() {
		
		System.out.println("\n\n=== Client Registration ===\n");
		
		StdInput object = new StdInput();

		
		/*
		 * name = object.read("name"); address = object.read("address"); DoB =
		 * object.read("date of birth (DD/MM/YYYY)");
		 */		
		
		username = object.read("username");
		password = object.read("password");
		password2 = object.read("password again");
				
	}
	
	

	private String checkTransactionStructure() throws ParseException {
		
		//if( name == null || address == null || DoB == null ) return "Error client transaction";

		if( username.isEmpty() || password.isEmpty() ) return "Error profile transaction";

		if (password.equals(password2) == false) return "Error password mismatch";

		return null;
	}
	
	private void executeRegistrationTransaction(List<BankClient> clients) throws ParseException {
		
		BankClient client = new BankClient(username, password);
		
		clients.add( client );
		
		//CreateClientProfileTransaction profile = new CreateClientProfileTransaction();
		//profile.createClientProfile(client);
		
	}

	private void printErrorMessage(String error) {

	System.err.println( error );		
	}
			
	
}
