package CyberSecurityTEST;

import java.text.ParseException;
import java.util.List;

public class RegisterClientTransactionImpl1 implements RegisterClientTransaction{
	
	private String username;
	private String password;
	private String password2;
	
	
	public void registerNewClient() throws ParseException {
		
		provideRegistrationDetails();
		
		String error = checkTransactionStructure();
		
		if( error != null ) printErrorMessage( error );

		else executeRegistrationTransaction();
		
	}

	private void provideRegistrationDetails() {
		
		System.out.println("\n\n=== Client Registration ===\n");
		StdInput object = new StdInput();	
		
		username = object.read("username");
		password = object.read("password");
		password2 = object.read("password again");
				
	}
	

	private String checkTransactionStructure() throws ParseException {
		
		if( username.isEmpty() || password.isEmpty() ) return "Error profile transaction";
		if (password.equals(password2) == false) return "Error password mismatch";

		return null;
	}
	
	private void executeRegistrationTransaction() throws ParseException {
		
		BankClient client = new BankClient(username, password);
		//clients.add( client );
		
		//singleton pattern
		BankClientDictionarySingleton s1 = BankClientDictionarySingleton.getInstance();
		s1.addBankClient(client);
		
	}

	private void printErrorMessage(String error) {

		System.err.println( error );		
	}
		
}
