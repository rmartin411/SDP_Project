package NonPrincipledDesign;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class RegisterBankClient {
	
	public static BankClient ProvideUserDetails() throws ParseException {
		
		System.out.println("\n\n===Client registration===\n");
		
		String name = read("Name");	
		String address = read("Address");		
		String DoB = read("Date of birth (DD/MM/YYYY)");		
		
		String username = read("username");
		String password = read("Password");
		
		BankClient client = new BankClient(name, address, new SimpleDateFormat("dd/MM/yyyy").parse(DoB), username, password);
		
		return client;
		
		
	}
	
	public static void checkRegistrationStructure() {
		
	}
	
	
	
	public static String read( String label ) {

		System.out.println( "\nProvide your " + label + ":" );

		System.out.println( ">" );


		BufferedReader input = new BufferedReader( new InputStreamReader( System.in ) );

		String value = null;

		try {

			value = input.readLine();
		}

		catch (IOException ex) { ex.printStackTrace(); }


		return value;
	}

}
