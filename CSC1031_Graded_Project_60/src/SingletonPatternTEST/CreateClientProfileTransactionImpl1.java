package SingletonPatternTEST;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class CreateClientProfileTransactionImpl1 extends TransactionTemplate implements CreateClientProfileTransaction{
	
	private BankClient clientLoggedIn;
	private String name; 
	private String address; 
	private String DoB;
	 
	public void createClientProfile(BankClient clientLoggedIn) throws ParseException {
		
		this.clientLoggedIn = clientLoggedIn;
		
		transaction();
		
	}
	
	/*
	private void provideDetails() {
		
		System.out.println("\n\n=== Client Profile Creation ===\n");
		
		StdInput object = new StdInput();

		name = object.read("name");	
		address = object.read("address");		
		DoB = object.read("date of birth (DD/MM/YYYY)");		
	
	}
	*/

	/*
	private String checkTransaction() {

		if( name == null || address == null || DoB == null ) return "Error client transaction";

		return null;
	}
	*/

	/*
	private void printErrorMessage(String error) {

		System.err.println( error );		
	}
	*/

	/*
	private void executeTransaction(BankClient clientLoggedIn) throws ParseException {
		clientLoggedIn.setProfileDetails(name, address, new SimpleDateFormat("dd/MM/yyyy").parse(DoB));
	}
	*/

	@Override
	public void provideDetails() {
		System.out.println("\n\n=== Client Profile Creation ===\n");
		
		StdInput object = new StdInput();

		name = object.read("name");	
		address = object.read("address");		
		DoB = object.read("date of birth (DD/MM/YYYY)");	
		
	}

	@Override
	public String checkTransaction() throws ParseException {
		if( name == null || address == null || DoB == null ) return "Error client transaction";

		return null;
	}

	@Override
	public void printErrorMessage(String message) {
		System.err.println( message );
		
	}

	@Override
	public void executeTransaction() {
		try {
			this.clientLoggedIn.setProfileDetails(name, address, new SimpleDateFormat("dd/MM/yyyy").parse(DoB));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}


}
