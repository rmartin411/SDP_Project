package SingletonPatternTEST;

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
	
	public static void printBankAccounts(BankClient client) {
		
		if (client.bankAccounts != null) {
			for (int i = 0; i <client.bankAccounts.size(); i++) { // iterate through list of their accounts
				System.out.println( "\tAccount Number = " + client.bankAccounts.get(i).accountNumber); 
				System.out.println( "\tAccount Type = " + client.bankAccounts.get(i).accountType); 
				System.out.println( "\tAccount Balance = " + client.bankAccounts.get(i).accountBalance + "\n\n"); 
			}	
		}
	}

}
