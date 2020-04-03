package CyberSecurityTEST;

import java.util.Date;

public class Appointment {
	
	public Date appointmentDate;
	public BankEmployee employee;
	public BankClient client;
	public Boolean scheduled;
	
	
	public Appointment(Date appDate, BankEmployee emp, BankClient client, Boolean scheduled) {
		
		boolean initialized = securityManagerCheck(appDate);
		
		if(initialized) init (appDate, emp, client, scheduled);
		else throw new SecurityException("Fake Date");
		
	}
	
	public void setScheduled(boolean value) {
		this.scheduled = value;
	}
	
	private boolean securityManagerCheck(Date date) {
		Date currentDate = new Date();
		if (date == null || date.after(currentDate)) {
			return false;
		}
		return true;
	}
	
	private void init(Date date, BankEmployee emp, BankClient client, Boolean scheduled) {
		this.appointmentDate = date;
		this.employee = emp;
		this.client = client;
		
		this.scheduled = false;
	}
	

}
