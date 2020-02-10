package NonPrincipledDesign;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
			
			String choice = read("choice");
			
			
			if (choice.equals("0")) {
				
				break;
			}
			
			else if (choice.equals("1")) {
				
				BankClient client = RegisterBankClient.ProvideUserDetails();
				
				bankClients.add(client);
			}
			
			else if (choice.equals("2")) {
				
				String usernameProvided = read("username");
				String passwordProvided = read("password");
				
				for (BankClient client : bankClients) {
					
					System.out.println(client.getName());
					
					if (client.getUsername().equals(usernameProvided) && client.getpassword().equals(passwordProvided)){
						
						System.out.println("\nHello " + client.getName() + "\n\n");
						
						BankClient clientLoggedIn = client;
						
						while(true) {
							
							System.out.println("\n0. Log out");
							System.out.println("1. Create profile");
							System.out.println("2. Create bank account");
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
							
							else if (clientChoice.equals("2")) { // create account
								
								BankAccount account = CreateSavingsAccount.createAccount();
								
								clientLoggedIn.bankAccounts.add(account);
								
								
																
							}
							
							else if (clientChoice.equals("3")) {
								
								clientLoggedIn.toPrint();
							}
							
							else if (clientChoice.equals("4")) {
								
								clientLoggedIn.toPrint();

							}
							
							else if (clientChoice.equals("5")) {
								
								System.out.println("\n\n===Transfer Money===\n");
								
								String withdrawAccountNum = read("withdrawal account number");	
								String depositAccountNum = read("deposited account number");		
								String amountToTransfer = read("amount to transfer");
								
								// checkTransactionStructure
								
								clientLoggedIn.makeTransfer(withdrawAccountNum, depositAccountNum, amountToTransfer);
								
							}
							
							else if (clientChoice.equals("6")) { // Book appointment
								
								System.out.println("\n\n===Book an appointment===\n");
								
								String withdrawAccountNum = read("Date of appointment");	
								String employee = read("Employee's name you wish to book an appointment with");
							}
							
							else if (clientChoice.equals("7")) { // Delete bank account
								
								System.out.println("\n\n===Delete a bank account===\n");
								
								String deleteAccountNum = read("account number to be deleted");	
								
								clientLoggedIn.deleteBankAccount(deleteAccountNum);
							}

						}
						
					}
					
				}
				
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
