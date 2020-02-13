package AllFR_SRP;

import java.util.Date;

public class Notification {
	
	public BankClient appointmentClient;
	public Date appointmentDate;
	
	
	public Notification(BankClient client, BankAdministrator admin, Date date) {
		
		this.appointmentClient = client;
		this.appointmentDate = date;
	}
	
	
	
	

}
