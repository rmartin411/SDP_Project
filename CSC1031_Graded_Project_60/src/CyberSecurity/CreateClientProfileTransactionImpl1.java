package CyberSecurity;

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
			new BankClientProfile(clientLoggedIn, name,address,new SimpleDateFormat("dd/MM/yyyy").parse(DoB));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
	}
}
