package CyberSecurityTEST;

import java.util.ArrayList;

public class BankClientCredentials {
	
	private String username;
	private String password;

	public BankClientCredentials(String username, String password) {
		boolean initialised = securityManagerCheck(username, password);
		
		if (initialised) init (username, password);
		else throw new SecurityException ("Fake Credentials");
	}

	private void init(String username, String password) {
		this.username = username;
		this.password = password;
	
	}

	private boolean securityManagerCheck(String username, String password) {
		if(username == null || username.charAt(0)=='$') return false;
		if (password == null || password.charAt(password.length() - 1) == '.') return false;
		
		return true;
	}

}

