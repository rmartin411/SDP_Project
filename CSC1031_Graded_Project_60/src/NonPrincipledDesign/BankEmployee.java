package NonPrincipledDesign;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.List;

public class BankEmployee {
	
	public List<Date> appointments;
	public List<BankEmployee> bankClients;
	
	
	public static void main(String[] args) {
		if (new File ("BankNotifications").exists() ) {
			
			String notifications = FileManager.read("BankNotifications");
			
			if (notifications != null) System.out.println("Received Notifications: " + notifications);
			
			// instantiate objects of appointments
			
			
			
		}
		
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
