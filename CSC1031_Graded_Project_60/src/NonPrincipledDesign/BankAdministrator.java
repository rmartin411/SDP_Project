package NonPrincipledDesign;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BankAdministrator extends User{
	
	
	private static int nextAdminID = 1;
	public int AdminID;
	
	public List<Notification> notifications;
	
	public BankAdministrator(String name, String address, Date DoB) {
		super(name, address, DoB);
		
		this.AdminID = getNextAdminID();
		
		notifications = new ArrayList<Notification>();
	}
	
	public int getNextAdminID() {
		int id = nextAdminID;
		nextAdminID++;
		return id;
	}
	
	

}
