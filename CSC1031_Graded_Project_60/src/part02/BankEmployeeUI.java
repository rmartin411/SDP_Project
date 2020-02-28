package part02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class BankEmployeeUI {

	public static void main(String[] args) throws ParseException {
			
		List<Appointment> toBeScheduledBookings = new ArrayList<Appointment>();
		List<Appointment> scheduledBookings = new ArrayList<Appointment>();

		User employee = new BankEmployee("EmployeeName");
		
		User client1 = new BankClient("Ross Martin", "QUB", new SimpleDateFormat("dd/MM/yyy").parse("12/01/2001"), "username1", "password1");
		User client2 = new BankClient("Austin Martin", "BHS", new SimpleDateFormat("dd/MM/yyy").parse("22/08/2004"), "username1", "password1");
		
		/*
		 * BankAccount account = new PrimaryAccount("primary", 1234.56); BankAccount
		 * account1 = new SavingsAccount("savings", 6543.21); BankAccount account2 = new
		 * PrimaryAccount("primary", 0.21); BankAccount account3 = new
		 * SavingsAccount("savings", 0.0);
		 * 
		 * ((BankClient)client1).bankAccounts.add(account);
		 * ((BankClient)client1).bankAccounts.add(account1);
		 * 
		 * ((BankClient)client2).bankAccounts.add(account2);
		 * ((BankClient)client2).bankAccounts.add(account3);
		 */
		Appointment appointment = new Appointment(new SimpleDateFormat("dd/MM/yyy").parse("12/01/2001"), (BankEmployee)employee, (BankClient)client1, false);
		Appointment appointment2 = new Appointment(new SimpleDateFormat("dd/MM/yyy").parse("12/01/2001"), (BankEmployee)employee, (BankClient)client2, false);
		
		toBeScheduledBookings.add(appointment);
		toBeScheduledBookings.add(appointment2);
		
		//ListPrint.printAppointment(toBeScheduledBookings);
		
		System.out.println("\n\n== Bookings to be Schelduled ==\n");
		
		if (toBeScheduledBookings != null) {
		
			for (int index = 0; index < toBeScheduledBookings.size(); index++) {
			
				Appointment app = toBeScheduledBookings.get(index);

				String dateOfAppointment = app.appointmentDate.toGMTString();
				String employeeName = app.employee.name;
				String clientName = app.client.name;
			
				System.out.println("-----------------------------------");
				System.out.println("Appointment Details:");
				System.out.println("-------------------- \n");
				System.out.println("Client Name: " + clientName);
				System.out.println("Date: " + dateOfAppointment);
				System.out.println("Employee: " + employeeName);
				System.out.println("-----------------------------------");
			
				
			}

		
			for (int indexBook = 0; indexBook < toBeScheduledBookings.size(); indexBook++) {
				
				ScheduleAppointmentTransaction schAppointment = new ScheduleAppointmentTransaction();
				schAppointment.scheduleAppointmentTransaction(indexBook, toBeScheduledBookings, scheduledBookings );
			}
		}
		
		//SListPrint.printAppointment(toBeScheduledBookings);
	}
}
