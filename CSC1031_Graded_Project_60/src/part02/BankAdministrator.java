package part02;

import java.util.ArrayList;
import java.util.List;

public class BankAdministrator extends User{
	
	
	private static int nextAdminID = 1;
	public int adminID;
	
	public List<Notification> notifications;
	
	public List<BankAccount> clientBankAccountToVerify;
	public List<BankClient> ClientProfileToVerify;
	
	public BankAdministrator(String name) {
		super(name);
		
		this.adminID = getNextAdminID();
		
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
		System.out.println("Bank Administrator Details:");
		System.out.println("----------------------\n\n");
		
		System.out.println("Admin ID: " + adminID);
		System.out.println("Name: " + name);
		
	}
	
	

}
