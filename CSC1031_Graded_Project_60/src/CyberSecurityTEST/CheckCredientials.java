package CyberSecurityTEST;

public class CheckCredientials {
	
	private String username;
	private String password;

	public CheckCredientials(String username, String password) {
		boolean initialised = checkUserCredientials(username, password);
		
		if (initialised) init (username, password);
		else throw new SecurityException ("Security Exception thrown");
	}

	private void init(String username, String password) {
		this.username = username;
		this.password = password;
	
	}

	private boolean checkUserCredientials(String username, String password) {
		if(username.charAt(0)=='$') return false;
		if (password.charAt(password.length() - 1) == '.') return false;
		
		return true;
	}

}
