package CyberSecurityTEST;

import java.util.Date;

public class BankClientProfile{
	
	private Date DoB;
	private String address;
	
	public BankClientProfile(String name, String address, Date DoB) {
		
		boolean initialized = securityManagerCheck(DoB);
		
		if(initialized) init (DoB, address);
		else throw new SecurityException("Fake Profile Details");
		
	}
	
	private boolean securityManagerCheck(Date DoB) {
		Date currentDate = new Date();
		if (DoB == null || DoB.after(currentDate)) {
			return false;
		}
		return true;
	}
	
	private void init(Date DoB, String address) {
		this.DoB = DoB;
		this.address = address;
	}
}
