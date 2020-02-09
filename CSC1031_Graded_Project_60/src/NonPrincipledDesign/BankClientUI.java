package NonPrincipledDesign;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class BankClientUI {
	
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
				
				RegisterBankClient.UserDetails();
			}
			
			else if (choice.equals("2")) {
				
				String usernameProvided = read("username");
				String passwordProvided = read("password");
				
				for (BankClient client : bankClients) {
					
					if (client.getUsername().equals(usernameProvided) && client.getpassword().equals(passwordProvided)){
						
						System.out.println("\nHello " + client.getName() + "\n\n");
						
						while(true) {
							
							System.out.println("\n0. Log out");
							System.out.println("1. Create profile");
							System.out.println("2. Create account");
							System.out.println("3. View account");
							System.out.println("4. View profile");
							System.out.println("5. Transfer money");
							System.out.println("6. Book appointment");
							System.out.println("7. Delete bank account");
							
							String clientChoice = read("choice");
							
							
							if (clientChoice.equals("0")) {
								
								break;
							} 
							
							else if (clientChoice.equals("1")) {
								
								break;
							}
							
							else if (clientChoice.equals("2")) {
								
								break;
							}
							
							else if (clientChoice.equals("3")) {
								
								break;
							}
							
							else if (clientChoice.equals("4")) {
								
								break;
							}
							
							else if (clientChoice.equals("5")) {
								
								break;
							}
							
							else if (clientChoice.equals("6")) {
								
								break;
							}
							
							else if (clientChoice.equals("7")) {
								
								break;
							}

						}
						
					}
					
				}
				
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
