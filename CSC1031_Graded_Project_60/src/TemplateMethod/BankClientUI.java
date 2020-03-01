package TemplateMethod;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class BankClientUI {
	
public static void main(String[] args) throws ParseException {
		
		List<BankClient> bankClients = new ArrayList<>();
		
		StdInput input = new StdInput();
		
		while(true) {
			ListPrint.printBankClient(bankClients);
			
			System.out.println("== Welcome to the Bank App ==");
			
			System.out.println("\n0. Exit");
			System.out.println("1. Register");
			System.out.println("2. Login");
	
			String choice = input.read("choice");
			
			if (choice.equals("0")) {
				
				break;
			}
			
			else if (choice.equals("1")) {
				
				RegisterClientTransaction object = new RegisterClientTransactionImpl1();
				object.registerNewClient(bankClients);
				
				CreateClientProfileTransaction objectCreateProfile = new CreateClientProfileTransactionImpl1();
				objectCreateProfile.createClientProfile(bankClients.get(bankClients.size()-1)); // the last user registered is the user is the last user in the list of bankCLients.
				
				do {
					
					CreateBankAccountTransaction objectCreateBankAccount = new CreateBankAccountTransaction();
					objectCreateBankAccount.createNewBankAccount(bankClients.get(bankClients.size()-1).bankAccounts);	
					
					System.out.println("\nWould you like to add another account?");
					System.out.println("0. No extra accounts");
					System.out.println("1. Extra account");

					
					String accountChoice = input.read("choice");
					
					
					
					if (accountChoice.equals("1") == false) {
						break;
					}
				}
				
				while(true);
				
				/*
				 * List<BankClient> client = new ArrayList<BankClient>(); //create a list of
				 * just the newly registered client
				 * client.add(bankClients.get(bankClients.size()-1));
				 * 
				 * ListPrint.printBankClient(client);
				 */
				bankClients.get(bankClients.size()-1).print();
				
			}
			
			else if (choice.equals("2")) {
				
				ClientLogInTransaction object1 = new ClientLogInTransaction();
					
				User clientLoggedIn = object1.clientLogin(bankClients);
				
				if (clientLoggedIn != null) {
					
					clientLoggedIn.print();
						
						while(true) {
							
							System.out.println("\n0. Log out");
							System.out.println("1. Change Bank Account Details");
							System.out.println("2. Delete Bank Account");
							System.out.println("3. Money Transfer");
							System.out.println("4. Book Appointment");
							
							String clientChoice = input.read("choice");
							
							if (clientChoice.equals("0")) {
								
								break;
							} 
							
							else if (clientChoice.equals("1")) { // Change client details
								
								ChangeClientDetailsTransaction object = new ChangeClientDetailsTransaction();
								object.changeClientDetails((BankClient)clientLoggedIn);
								
							}
							
							else if (clientChoice.equals("2")) { // delete bank account
								
								DeleteBankAccountTransaction object = new DeleteBankAccountTransaction();
								object.deleteBankAccount((BankClient)clientLoggedIn);
													
							}
							
							else if (clientChoice.equals("3")) { // Money Transfer
								
								MoneyTransferTransaction object = new MoneyTransferTransaction();
								object.makeMoneyTransfer((BankClient)clientLoggedIn);
								
								//ListPrint.printBankClient(bankClients);
								
							}
							
							else if (clientChoice.equals("4")) { //Book Appointment
								
								BookAppointmentTransaction object = new BookAppointmentTransaction();
								object.bookAppointmentTransaction((BankClient)clientLoggedIn);
								
							}
						}
					}
				}
			}
		}
}
