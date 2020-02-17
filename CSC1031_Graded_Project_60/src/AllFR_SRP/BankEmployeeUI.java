package AllFR_SRP;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class BankEmployeeUI {

	public static void main(String[] args) throws ParseException {
				
		List<Appointment> toBeScheduledBookings = new ArrayList<Appointment>();
		List<Appointment> scheduledBookings = new ArrayList<Appointment>();

		BankEmployee employee = new BankEmployee("EmployeeName", "QUB", new SimpleDateFormat("dd/MM/yyy").parse("12/01/2001"));
		
		BankClient client1 = new BankClient("Ross Martin", "QUB", new SimpleDateFormat("dd/MM/yyy").parse("12/01/2001"), "username1", "password1");
		BankClient client2 = new BankClient("Austin Martin", "BHS", new SimpleDateFormat("dd/MM/yyy").parse("22/08/2004"), "username1", "password1");
		
		BankAccount account = new BankAccount("primary", 1234.56);
		BankAccount account1 = new BankAccount("savings", 6543.21);
		BankAccount account2 = new BankAccount("primary", 0.21);
		BankAccount account3 = new BankAccount("savings", 0.0);
		
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
				
				
				
				/*
				 * Appointment object = toBeScheduledBookings.get(index);
				 * 
				 * StdInput input = new StdInput();
				 * 
				 * String date = object.appointmentDate.toGMTString(); String emp =
				 * object.employee.name; String cli = object.client.name;
				 * 
				 * System.out.println("Appointment Details:");
				 * System.out.println("-------------------- \n");
				 * 
				 * System.out.println("Client Name: " + cli); System.out.println("Date: " +
				 * date); System.out.println("Employee: " + emp + "\n\n");
				 * 
				 * 
				 * 
				 * System.out.println( "1. Book it" ); System.out.println( "2. Do not book it"
				 * );
				 * 
				 * String answer = input.read(" answer ");
				 */
				
				/*
				 * if (answer.equals("1")) {
				 * 
				 * toBeScheduledBookings.remove(object); scheduledBookings.add(object);
				 * 
				 * System.out.println("Appointment has been scheduled with " +
				 * object.client.name); } else if (answer.equals("2")){
				 * toBeScheduledBookings.remove(object);
				 * System.out.println("Appointment has not been scheduled with " +
				 * object.client.name);
				 * 
				 * }
				 */
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
