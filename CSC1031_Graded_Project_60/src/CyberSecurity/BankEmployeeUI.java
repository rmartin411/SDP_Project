package CyberSecurity;

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
		
		Appointment appointment = new Appointment(new SimpleDateFormat("dd/MM/yyy").parse("12/01/2001"), (BankEmployee)employee, (BankClient)client1, false);
		Appointment appointment2 = new Appointment(new SimpleDateFormat("dd/MM/yyy").parse("12/01/2001"), (BankEmployee)employee, (BankClient)client2, false);
		
		toBeScheduledBookings.add(appointment);
		toBeScheduledBookings.add(appointment2);
		
		System.out.println("\n\n== Bookings to be Schelduled ==\n");
		
		if (toBeScheduledBookings != null) {			
			ListPrint.printAppointments(toBeScheduledBookings);
		
			for (int indexBook = 0; indexBook < toBeScheduledBookings.size(); indexBook++) {
				ScheduleAppointmentTransaction schAppointment = new ScheduleAppointmentTransaction();
				schAppointment.scheduleAppointmentTransaction(indexBook, toBeScheduledBookings, scheduledBookings );
			}
		}		
	}
}
