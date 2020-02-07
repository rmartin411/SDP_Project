package NonPrincipledDesign;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


public class BankClient {
	
	public static final AtomicInteger clientCount = new AtomicInteger(0);
	
	public int clientID;
	public String name;
	public String address;
	public Date DoB;
	
	public String username;
	public String password;
	
	public List<String> accountNumbers;
	public List<String> accountTypes;
	public List<Double> accountBalances;
	
	public List<Date> appointments;
	public List<BankEmployee> bankEmployee;
	
	
	// Constructor
	public BankClient(int clientID, String name, String address, Date DoB, String username, String password) {
		
		this.clientID = clientID;
		this.name = name;
		this.address = address;
		this.DoB = DoB;
		this.username = username;
		this.password = password;
		
		
	}
	
	public void addAccount(String accountNumber, String accountType, double balance) {
		
		if (accountNumber != null && accountType != null && balance >= 0.0) {
			accountNumbers.add(accountNumber);
			accountTypes.add(accountType);
			accountBalances.add(balance);
		}	
	}
	
	public void toPrint() {

		System.out.println( "Client ID = " + clientID + ", Name = " + name + "\n\nAddress = " + address + ", Date of Birth = " + DoB + ",Username = " + username);


		if (accountNumbers != null) {
			for (int i = 0; i <accountNumbers.size(); i++) { // iterate through list of their accounts
				System.out.println( "\tAccount Number = " + accountNumbers.get(i)); 
				System.out.println( "\tAccount Type = " + accountTypes.get(i)); 
				System.out.println( "\tAccount Number = " + accountBalances.get(i) + "\n\n"); 
			}	
		}
	}
	
	public static void main(String[] args) throws ParseException {
		
		List<BankClient> bankClients = new ArrayList<>();
		
		while(true) {
			print(bankClients);
			
			System.out.println("\n0. Exit");
			System.out.println("1. Register");
			System.out.println("2. Login");
			System.out.println("3. Delete Bank account");
			System.out.println("4. Book Appointment");
			
			String choice = read("choice");
			
			
			if (choice.equals("0")) {
				
				break;
			}
			
			else if (choice.equals("1")) {
				
				break;
			}
			
			else if (choice.equals("2")) {
				
				break;
			}
			
			else if (choice.equals("3")) {
	
				break;
			}
			
			else if (choice.equals("4")) {
	
				break;
			}
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
	
	public static void print( List<BankClient> clients ) {

		System.out.println( "Bank Clients:\n" );

		for( int i = 0; clients != null && i < clients.size(); ++i ) clients.get( i ).toPrint();
	}


	
	
	
	

}
