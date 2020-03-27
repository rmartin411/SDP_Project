package CyberSecurityTEST;

import java.util.List;

public class ClientLogInTransaction  {
	
	public String usernameProvided;
	public String passwordProvided;
	
	public BankClient clientLogin() {
		
		provideLogInDetails();
		
		String error = checkTransactionStructure();
		
		if(error != null ) {
			printErrorMessage( error );
		}
		
		else {
			BankClient clientLoggedIn = executeClientLogInTransaction();
			return clientLoggedIn;
		}
		return null;
	}
	
	private void provideLogInDetails() {
		
		System.out.println("\n\n=== Client Log In ===\n");
		
		StdInput object1 = new StdInput();
		
		usernameProvided = object1.read("username");
		passwordProvided = object1.read("password");
		
	}
	
	
	public String checkTransactionStructure() {
		
		if ( usernameProvided.isEmpty() || passwordProvided.isEmpty()) return "Error Login Transaction";
			
		return null;
	}
	public void printErrorMessage(String error) {
		
		System.err.println( error );
		
	}
	
	public BankClient executeClientLogInTransaction() {
		
		BankClient clientLoggedIn = null;
		
		BankClientDictionarySingleton s2 = BankClientDictionarySingleton.getInstance();
		int pos = s2.searchBankClient(usernameProvided, passwordProvided);
		clientLoggedIn = s2.get(pos);
		
		if (clientLoggedIn != null) {
			System.out.println("\nHello " + clientLoggedIn.getUsername() + "\n\n");
		}
		
		/*
		 * for (BankClient client : bankClients) {
		 * 
		 * if (client.getUsername().equals(usernameProvided) &&
		 * client.getpassword().equals(passwordProvided)){ clientLoggedIn = client;
		 * System.out.println("\nHello " + clientLoggedIn.getUsername() + "\n\n"); }
		 * 
		 * }
		 */
		
		return clientLoggedIn;
		
	}
	
}
