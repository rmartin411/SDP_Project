package CyberSecurity;

import java.util.ArrayList;

public class BankClientCredentials extends BankClient{
	
	public BankClientCredentials(String username, String password) { // used on registration
		// TODO Auto-generated constructor stub
		
		super(username, password);
		
	
		
		this.clientID = getNextClientID();

		this.username = username;
		this.password = password;
		
		bankAccounts = new ArrayList<BankAccount>();
		bookedAppointments = new ArrayList<Appointment>();
		ScheduledAppointments = new ArrayList<Appointment>();
		
		clientCount.incrementAndGet();
	}
	
	
	
	

}
