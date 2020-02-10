package NonPrincipledDesign;

import java.util.Date;

public class Appointments {
	
	public Date appointmentDate;
	public BankEmployee employee;
	public BankClient client;
	
	
	public Appointments(Date appDate, BankEmployee emp, BankClient client) {
		
		this.appointmentDate = appDate;
		this.employee = emp;
		this.client = client;
	}
	
	
	

}
