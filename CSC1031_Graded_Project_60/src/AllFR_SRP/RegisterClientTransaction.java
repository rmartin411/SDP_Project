package AllFR_SRP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.List;

//import exampleGroupProject.principledDesign.principles.SRP.FR1_SRP.StdInput;



public class RegisterClientTransaction  {
	
	private String name;
	private String address;
	private String DoB;
	private String username;
	private String password;
	private String password2;
	
	
	public void registerNewClient(List<BankClient> clients) throws ParseException {
		
		provideClientDetails();
		
		String error = checkTransactionStructure();
		
		if( error != null ) printErrorMessage( error );

		else executeRegistrationTransaction( clients );
		
	}

	private void provideClientDetails() {
		
		System.out.println("\n\n===Client Registration===\n");
		
		StdInput object = new StdInput();

		
		name = object.read("name");	
		address = object.read("address");		
		DoB = object.read("date of birth (DD/MM/YYYY)");		
		
		username = object.read("username");
		password = object.read("password");
		password2 = object.read("password again");
				
	}
	
	

	private String checkTransactionStructure() throws ParseException {
		
		if( name == null || address == null || DoB == null ) return "Error client transaction";

		if( username == null || password == null ) return "Error profile transaction";

		if (password.equals(password2) == false) return "Error password mismatch";

		return null;
	}
	
	private void executeRegistrationTransaction(List<BankClient> clients) throws ParseException {
		
		BankClient client = new BankClient(name, address, new SimpleDateFormat("dd/MM/yyyy").parse(DoB), username, password);
		
		clients.add( client );
		
	}

	private void printErrorMessage(String message) {

	System.err.println( message );		
	}
			
	/*
	 * public static String read( String label ) {
	 * 
	 * System.out.println( "\nProvide your " + label + ":" );
	 * 
	 * System.out.println( ">" );
	 * 
	 * 
	 * BufferedReader input = new BufferedReader( new InputStreamReader( System.in )
	 * );
	 * 
	 * String value = null;
	 * 
	 * try {
	 * 
	 * value = input.readLine(); }
	 * 
	 * catch (IOException ex) { ex.printStackTrace(); }
	 * 
	 * 
	 * return value; }
	 */
}
