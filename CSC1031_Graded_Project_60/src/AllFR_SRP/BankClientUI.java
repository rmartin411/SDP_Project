package AllFR_SRP;

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
		
		StdInput input = new StdInput();
		
		while(true) {
			//print(bankClients);
			
			System.out.println("\n0. Exit");
			System.out.println("1. Register");
			System.out.println("2. Login");
			
			String choice = input.read("choice");
			
			
			if (choice.equals("0")) {
				
				break;
			}
			
			else if (choice.equals("1")) {
				
				RegisterClientTransaction object = new RegisterClientTransaction();
				
				object.registerNewClient(bankClients);
				
				
			}
			
			else if (choice.equals("2")) {
				
				ClientLogInTransaction object1 = new ClientLogInTransaction();
					
				BankClient clientLoggedIn = object1.clientLogin(bankClients);
				
				if (clientLoggedIn != null) {
						
						while(true) {
							
							System.out.println("\n0. Log out");
							System.out.println("1. Create profile");
							System.out.println("2. Create bank account");
							System.out.println("3. View account details");
							System.out.println("4. View profile details");
							System.out.println("5. Change profile details");
							System.out.println("6. Transfer money");
							System.out.println("7. Book appointment");
							System.out.println("8. Delete bank account");
							
							String clientChoice = input.read("choice");
							
							if (clientChoice.equals("0")) {
								
								break;
							} 
							
							else if (clientChoice.equals("1")) {
								
								CreateClientProfileTransaction object = new CreateClientProfileTransaction();
								
								object.createClientProfile(clientLoggedIn);
							}
							
							else if (clientChoice.equals("2")) { // create account
								
								CreateBankAccountTransaction object = new CreateBankAccountTransaction();
								
								object.createNewBankAccount(clientLoggedIn.bankAccounts);	
																
							}
							
							else if (clientChoice.equals("3")) {
								
								clientLoggedIn.print();
							}
							
							else if (clientChoice.equals("4")) {
								
								clientLoggedIn.print();

							}
							
							else if (clientChoice.equals("5")) {
								
								ChangeClientDetailsTransaction object = new ChangeClientDetailsTransaction();
								
								object.changeClientDetails(clientLoggedIn);

							}
							
							else if (clientChoice.equals("6")) {
								
								MoneyTransferTransaction object = new MoneyTransferTransaction();
								
								object.makeMoneyTransfer(clientLoggedIn);
								
							}
							
							else if (clientChoice.equals("7")) { // Book appointment
								
								BookAppointmentTransaction object = new BookAppointmentTransaction();
								
								object.bookAppointmentTransaction(clientLoggedIn);
								
							}
							
							else if (clientChoice.equals("8")) { // Delete bank account
								
								DeleteBankAccountTransaction object = new DeleteBankAccountTransaction();
								
								object.deleteBankAccount(clientLoggedIn);
								
							}
						}
					}
				
				}
			}
		}
		
	public static void print( List<BankClient> clients ) {

		System.out.println( "Bank Clients:\n" );

		for( int i = 0; clients != null && i < clients.size(); ++i ) clients.get( i ).print();
	}

}
