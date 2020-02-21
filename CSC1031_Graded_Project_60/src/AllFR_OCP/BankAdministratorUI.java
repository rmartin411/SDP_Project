package AllFR_OCP;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class BankAdministratorUI {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		List<Notification> listOfNotifications = new ArrayList<Notification>();
	
		//List<BankAccount> toBeVerifiedAccounts = new ArrayList<BankAccount>();
		//List<BankAccount> VerifiedAccounts = new ArrayList<BankAccount>();
		  
		User admin = new BankAdministrator("Admin");
		  
		User client1 = new BankClient("Ross Martin", "QUB", new
				SimpleDateFormat("dd/MM/yyy").parse("12/01/2001"), "username1", "password1");
		User client2 = new BankClient("Austin Martin", "BHS", new
		  SimpleDateFormat("dd/MM/yyy").parse("22/08/2004"), "username1", "password1");
		  
		BankAccount account = new PrimaryAccount("primary", 1234.56);
		BankAccount account1 = new SavingsAccount("savings", 6543.21);
		BankAccount account2 = new PrimaryAccount("primary", 0.21);
		BankAccount account3 = new SavingsAccount("savings", 0.0);
		  
		((BankClient)client1).bankAccounts.add(account); 
		//toBeVerifiedAccounts.add(account);
		  
		((BankClient)client1).bankAccounts.add(account1);
		//toBeVerifiedAccounts.add(account1);
		  
		((BankClient)client2).bankAccounts.add(account2); 
		//toBeVerifiedAccounts.add(account2);
		  
		((BankClient)client2).bankAccounts.add(account3);
		//toBeVerifiedAccounts.add(account3);		  
		  
		Notification notification = new Notification((BankClient)client1, account);
		Notification notification1 = new Notification((BankClient)client1, account1);
		Notification notification2 = new Notification((BankClient)client2, account2);
		Notification notification3 = new Notification((BankClient)client2, account3);
		  
		listOfNotifications.add(notification);
		listOfNotifications.add(notification1);
		listOfNotifications.add(notification2);
		listOfNotifications.add(notification3);

		System.out.println(listOfNotifications.size());	
		
		System.out.println("\n\n== Accounts to be Verified ==\n");
			
		if (listOfNotifications != null) {
			for (int index = 0; index < listOfNotifications.size(); index++) {
					
				VerifyAccountTransaction verAccount = new VerifyAccountTransaction();
				verAccount.verifyAccountTransaction(index, listOfNotifications);
			}
		} 
	}

}
