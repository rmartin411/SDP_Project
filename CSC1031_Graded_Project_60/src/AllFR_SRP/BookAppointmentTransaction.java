package AllFR_SRP;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class BookAppointmentTransaction implements TransactionInterface  {
	
	public String dateOfAppointment;
	public String nameOfEmployee;
	
	public BankEmployee employee;
	
	
	public void bookAppointmentTransaction(BankClient clientLoggedIn) throws ParseException {
		
		provideBookingDetails();
		
		String error = checkTransactionStructure();
		
		if( error != null ) printErrorMessage( error );

		else executeBookingTransaction( clientLoggedIn );
		
		
	}

	private void provideBookingDetails() {
		// TODO Auto-generated method stub
		
		System.out.println("\n\n===Book an appointment===\n");
		
		StdInput object = new StdInput();

		
		dateOfAppointment = object.read("Date of appointment");	
		nameOfEmployee = object.read("Employee's name you wish to book an appointment with");
		
	}

	public String checkTransactionStructure() {
		// TODO Auto-generated method stub
		return null;
	}

	public void printErrorMessage(String error) {

		System.out.println( error );
	}

	private void executeBookingTransaction(BankClient clientLoggedIn) throws ParseException {
		// TODO Auto-generated method stub
		
		Appointments object = new Appointments(new SimpleDateFormat("dd/MM/yyyy").parse(dateOfAppointment), employee, clientLoggedIn);
		
		employee.appointments.add(object);
	}

}
