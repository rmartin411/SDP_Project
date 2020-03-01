package part02;

import java.util.List;

public class ListPrint {
	
	public static void printBankClient(List<BankClient> clients ) {

		System.out.println( "Bank Clients:\n" );

		for( int i = 0; clients != null && i < clients.size(); ++i ) {
			clients.get( i ).print();
		}
	}
	
	public static void printAppointment(List<Appointment> appointment) {
		
		System.out.println("Appointments: \n");
		
		for (int a = 0; a < appointment.size(); a ++) {
			System.out.println(appointment.get(a).client.name);
		}
		
	}
	
	public static void printAppointments(List<Appointment> toBeScheduledBookings) {
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

	}

}
