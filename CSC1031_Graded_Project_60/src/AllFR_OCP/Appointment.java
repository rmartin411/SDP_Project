package AllFR_OCP;

import java.util.Date;

public class Appointment {
	
	public Date appointmentDate;
	public BankEmployee employee;
	public BankClient client;
	public Boolean scheduled;
	
	
	public Appointment(Date appDate, BankEmployee emp, BankClient client, Boolean scheculded) {
		
		this.appointmentDate = appDate;
		this.employee = emp;
		this.client = client;
		
		this.scheduled = false;
	}
	
	public void setScheduled(boolean value) {
		this.scheduled = value;
	}
	
	

}
