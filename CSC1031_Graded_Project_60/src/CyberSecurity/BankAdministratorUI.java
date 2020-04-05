	package CyberSecurity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class BankAdministratorUI {

	public static void main(String[] args) throws ParseException {		
		
		List<Notification> listOfNotifications = new ArrayList<Notification>();
		  
		User admin = new BankAdministrator("Admin");
		User client1 = new BankClient("Ross Martin", "QUB", new
				SimpleDateFormat("dd/MM/yyy").parse("12/01/2001"), "username1", "password1");
		User client2 = new BankClient("Austin Martin", "BHS", new
		  SimpleDateFormat("dd/MM/yyy").parse("22/08/2004"), "username1", "password1");
		  
		BankAccount account = new PrimaryAccount("primary", 1234.56);
		BankAccount account1 = new SavingsAccount("savings", 6543.21);
		
		((BankClient)client1).bankAccounts.add(account); 
		((BankClient)client2).bankAccounts.add(account1);
		  		  
		Notification notification = new Notification((BankClient)client1, account);
		Notification notification1 = new Notification((BankClient)client1, account1);
		  
		listOfNotifications.add(notification);
		listOfNotifications.add(notification1);
		
		System.out.println("\n\n===== Accounts to be Verified =====\n");
			
		if (listOfNotifications != null) {
			for (int index = 0; index < listOfNotifications.size(); index++) {
				BankAccount accountVer = listOfNotifications.get(index).clientsAccount;
				User clientVer = listOfNotifications.get(index).client;
				
				System.out.println("-----------------------------------");
				System.out.println("Client ID: " + ((BankClient)clientVer).clientID);
				System.out.println("Client Name: " + ((BankClient)clientVer).name);
				System.out.println("--------------------");
				System.out.println("Account Type: " + accountVer.accountType);
				System.out.println("Account Number: " + accountVer.accountNumber);
				System.out.println("Account Balance: " + accountVer.accountBalance);
				System.out.println("-----------------------------------");
			}
			
			for (int index = 0; index < listOfNotifications.size(); index++) {
				VerifyAccountTransaction verAccount = new VerifyAccountTransaction();
				verAccount.verifyAccountTransaction(index, listOfNotifications);
			}
		} 
	}
}
