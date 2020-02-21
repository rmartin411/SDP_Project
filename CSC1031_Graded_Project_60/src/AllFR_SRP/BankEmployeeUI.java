package AllFR_SRP;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class BankEmployeeUI {

	public static void main(String[] args) throws ParseException {
		
		
				
		List<Appointment> toBeScheduledBookings = new ArrayList<Appointment>();
		List<Appointment> scheduledBookings = new ArrayList<Appointment>();

		BankEmployee employee = new BankEmployee("EmployeeName");
		
		BankClient client1 = new BankClient("Ross Martin", "QUB", new SimpleDateFormat("dd/MM/yyy").parse("12/01/2001"), "username1", "password1");
		BankClient client2 = new BankClient("Austin Martin", "BHS", new SimpleDateFormat("dd/MM/yyy").parse("22/08/2004"), "username1", "password1");
		
		BankAccount account = new PrimaryAccount("primary", 1234.56);
		BankAccount account1 = new SavingsAccount("savings", 6543.21);
		BankAccount account2 = new PrimaryAccount("primary", 0.21);
		BankAccount account3 = new SavingsAccount("savings", 0.0);
		
		client1.bankAccounts.add(account);
		client1.bankAccounts.add(account1);
		
		client2.bankAccounts.add(account2);
		client2.bankAccounts.add(account3);
		
		Appointment appointment = new Appointment(new SimpleDateFormat("dd/MM/yyy").parse("12/01/2001"), employee, client1, false);
		Appointment appointment2 = new Appointment(new SimpleDateFormat("dd/MM/yyy").parse("12/01/2001"), employee, client2, false);

		
		toBeScheduledBookings.add(appointment);
		toBeScheduledBookings.add(appointment2);

		
		print(toBeScheduledBookings);
		
		System.out.println("\n\n== Bookings to be Schelduled ==\n");
		
		if (toBeScheduledBookings != null) {
			for (int index = 0; index < toBeScheduledBookings.size(); index++) {
				
				ScheduleAppointmentTransaction schAppointment = new ScheduleAppointmentTransaction();
				schAppointment.scheduleAppointmentTransaction(index, toBeScheduledBookings, scheduledBookings );
			}
		}
		
		print(toBeScheduledBookings);

	}
	
	public static void print(List<Appointment> appointment) {
		
		for (int i = 0; i < appointment.size(); i ++) {
			System.out.println(appointment.get(i).client.name);
		}
		
	}

}
