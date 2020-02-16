package AllFR_SRP;

import java.util.List;

public class ScheduleAppointmentTransaction {
	
	private List<Appointment> toBeScheduled;
	private List<Appointment> scheduled;
	private int IndexAppointment;
	private Appointment app;
	private String answer;
	
	public void scheduleAppointmentTransaction(int index, List<Appointment> toBeScheduledBookings, List<Appointment> scheduledBookings) {
		
		this.toBeScheduled = toBeScheduled;
		this.scheduled = scheduled;
		this.IndexAppointment = index;
		
		provideDetails();
		
		String error = checkTransactionStructure();
		
		if( error != null ) printErrorMessage( error );

		else executeTransaction(toBeScheduledBookings, scheduledBookings);
	}

	private void provideDetails() {
		
		app = toBeScheduled.get(IndexAppointment);
		StdInput input = new StdInput();
		
		String dateOfAppointment = app.appointmentDate.toGMTString();
		String employeeName = app.employee.name;
		String clientName = app.client.name;
		System.out.println("Appointment Details:");
		System.out.println("-------------------- \n");
		System.out.println("Client Name: " + clientName);
		System.out.println("Date: " + dateOfAppointment);
		System.out.println("Employee: " + employeeName + "\n\n");

		System.out.println( "1. Book it" );
		System.out.println( "2. Do not book it" );
		 
		answer = input.read(" answer ");		
	}

	private String checkTransactionStructure() {
		
		if (answer.equals("1") || answer.equals("2")) return null;
		
		else {
			return "Incorrect option";
		}
	}

	private void printErrorMessage(String error) {
		System.err.println( error );
	}

	private void executeTransaction(List<Appointment> toBeScheduledBookings, List<Appointment> scheduledBookings) {

		if (answer.equals("1")) {
			toBeScheduledBookings.remove(app);
			scheduledBookings.add(app);
			
			app.setScheduled(true);
			
			System.out.println("Appointment has been scheduled with " + app.client.name);
		}
		
		else {
			
			toBeScheduledBookings.remove(app);
			System.out.println("Appointment has not been scheduled with " + app.client.name);

			
		}
	}

}
