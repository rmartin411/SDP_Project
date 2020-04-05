package CyberSecurity;

public class BankClientCredentials {

	public BankClientCredentials(String username, String password) {
		boolean initialised = securityManagerCheck(username, password);
		
		if (initialised) init (username, password);
		else throw new SecurityException ("Fake Credentials");
	}

	private void init(String username, String password) {
		BankClient client = new BankClient(username, password);
		
		 //singleton pattern 
		BankClientDictionarySingleton s1 = BankClientDictionarySingleton.getInstance(); 
		s1.addBankClient(client);
	}

	private boolean securityManagerCheck(String username, String password) {
		if(username == null || username.charAt(0)=='$') return false;
		if (password == null || password.charAt(password.length() - 1) == '.') return false;
		
		return true;
	}
}

