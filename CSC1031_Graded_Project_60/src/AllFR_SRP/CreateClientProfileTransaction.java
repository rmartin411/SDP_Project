package AllFR_SRP;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CreateClientProfileTransaction {
	
	private String name;
	private String address;
	private String DoB;
	
	public void createClientProfile(BankClient clientLoggedIn) throws ParseException {
		
		provideProfileDetails();
		
		String error = checkTransactionStructure();
		
		if( error != null ) printErrorMessage( error );

		else executeCreateProfileTransaction( clientLoggedIn );
	}

	private void provideProfileDetails() {
		
		System.out.println("\n\n=== Client Profile Creation ===\n");
		
		StdInput object = new StdInput();

		name = object.read("name");	
		address = object.read("address");		
		DoB = object.read("date of birth (DD/MM/YYYY)");		
	
	}

	private String checkTransactionStructure() {

		if( name == null || address == null || DoB == null ) return "Error client transaction";

		return null;
	}

	private void printErrorMessage(String error) {

		System.err.println( error );		
	}

	private void executeCreateProfileTransaction(BankClient clientLoggedIn) throws ParseException {
		clientLoggedIn.setProfileDetails(name, address, new SimpleDateFormat("dd/MM/yyyy").parse(DoB));
	}

}
