package CyberSecurity;

import java.util.Date;

public class BankClientProfile{
	
	private String name;
	private Date DoB;
	private String address;
	
	public BankClientProfile(BankClient client, String name, String address, Date DoB) {
		
		boolean initialized = securityManagerCheck(DoB);
		
		if(initialized) init (client, name, DoB, address);
		else throw new SecurityException("Fake Profile Details");
	}
	
	private boolean securityManagerCheck(Date DoB) {
		Date currentDate = new Date();
		if (DoB == null || DoB.after(currentDate)) {
			return false;
		}
		return true;
	}
	
	private void init(BankClient client, String name, Date DoB, String address) {
		this.name = name;
		this.DoB = DoB;
		this.address = address;
		
		client.setProfileDetails(name, address, DoB);
	}
}
