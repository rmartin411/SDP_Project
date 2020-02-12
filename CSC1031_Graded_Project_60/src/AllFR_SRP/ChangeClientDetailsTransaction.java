package AllFR_SRP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ChangeClientDetailsTransaction {
	
	public String name;
	public String address;
	public Date DoB;
	public String username;
	public String password;
	public String password2;
	
	
	public String DoBStr;
	
	
	public void changeClientDetails(BankClient clientLoggedIn) throws ParseException {
		
		this.name = clientLoggedIn.name;
		this.address = clientLoggedIn.address;
		this.DoB = clientLoggedIn.DoB;
		this.username = clientLoggedIn.username;
		this.password = clientLoggedIn.password;
		
		
		askChangeClientDetails(clientLoggedIn);
		
		String error = checkTransactionStructure();
		
		if( error != null ) printErrorMessage( error );

		else executeChangeClientDetailsTransaction( clientLoggedIn );
		
	}

	@SuppressWarnings("deprecation")
	public void askChangeClientDetails(BankClient clientLoggedIn) {
		
		System.out.println("\n\n===Change Client Details===\n");
		
		StdInput object = new StdInput();

		
		System.out.println("Would you like to change your name? (y or n) \n Current Name: " + name);
		String choiceName = object.read( "choice" );
	
		if(choiceName.toLowerCase().contentEquals("y")) {
			name = object.read("new name");		
		}
		
		System.out.println("Would you like to change your address? (y or n) \n Current address: " + address);
		String choiceAddress = object.read( "choice" );
	
		if(choiceAddress.toLowerCase().contentEquals("y")) {
			address = object.read("new address");		
		}
		
		System.out.println("Would you like to change your date of birth? (y or n) \n Current date of birth: " + DoB.getDate()+"/" + DoB.getMonth()+"/"+ DoB.getYear());
		String choiceDoB = object.read( "choice" );
	
		if(choiceDoB.toLowerCase().contentEquals("y")) {
			DoBStr = object.read("new date of birth (DD/MM/YYYY)");	
		}
		else {
			DoBStr = DoB.getDate()+"/" + DoB.getMonth()+"/"+ DoB.getYear();
		}
		
		System.out.println("Would you like to change your username? (y or n) \n Current username: " + username);
		String choiceUsername = object.read( "choice" );
	
		if(choiceUsername.toLowerCase().contentEquals("y")) {
			username = object.read("username");
		}
		
		System.out.println("Would you like to change your password? (y or n)");
		String choicePassword = object.read( "choice" );
	
		if(choicePassword.toLowerCase().contentEquals("y")) {
			password = object.read("new password");
			password2 = object.read("new password again");		}
				
	}
	
	

	public String checkTransactionStructure() throws ParseException {
		
		if( name == null || address == null || DoB == null ) return "Error client transaction";

		if( username == null || password == null ) return "Error profile transaction";

		if (password.equals(password2) == false) return "Error password mismatch";

		return null;
	}
	
	private void executeChangeClientDetailsTransaction(BankClient clientLoggedIn) throws ParseException {
		
		clientLoggedIn.changeCientDetails(name, address, new SimpleDateFormat("dd/MM/yyyy").parse(DoBStr), username, password);
		
	}

	private void printErrorMessage(String message) {

	System.err.println( message );		
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
