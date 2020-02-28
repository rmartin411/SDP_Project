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

}
