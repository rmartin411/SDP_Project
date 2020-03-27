package CyberSecurity;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class BookAppointmentTransaction   {
	
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
		
		System.out.println("\n\n===Book an appointment===\n");
		
		StdInput object = new StdInput();
		
		dateOfAppointment = object.read("Date of appointment");	
		nameOfEmployee = object.read("Employee's name you wish to book an appointment with");
		
	}

	public String checkTransactionStructure() {
		
		if (dateOfAppointment.isEmpty()) return "No date";
		
		if (nameOfEmployee.isEmpty()) return "No employee name provided";
	
		return null;
	}

	public void printErrorMessage(String error) {

		System.out.println( error );
	}

	private void executeBookingTransaction(BankClient clientLoggedIn) throws ParseException {
		// TODO Auto-generated method stub
		User Employee = new BankEmployee(nameOfEmployee);
		Appointment object = new Appointment(new SimpleDateFormat("dd/MM/yyyy").parse(dateOfAppointment), (BankEmployee)Employee, clientLoggedIn, false);
		
		clientLoggedIn.bookedAppointments.add(object);
		System.out.println("Employee has been sent a notification. They will get back to you to confirm if appointment can be scheduled");
		
		//employee.appointments.add(object);
		try {
			employee.notify(object);
		}
		catch(NullPointerException e) {
			System.out.print("");
		}
		
		clientLoggedIn.print();
		ListPrint.printAppointments(clientLoggedIn.bookedAppointments);
		
		
	}

}
