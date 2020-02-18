package AllFR_SRP;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BankAdministrator extends User{
	
	
	private static int nextAdminID = 1;
	public int AdminID;
	
	public List<Notification> notifications;
	
	public List<BankAccount> clientBankAccountToVerify;
	public List<BankClient> ClientProfileToVerify;
	
	public BankAdministrator(String name) {
		super(name);
		
		this.AdminID = getNextAdminID();
		
		notifications = new ArrayList<Notification>();
	}
	
	public int getNextAdminID() {
		int id = nextAdminID;
		nextAdminID++;
		return id;
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}
	
	

}
