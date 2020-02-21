package AllFR_OCP;

import java.util.List;

public class VerifyAccountTransaction {
	
	private List<Notification> listNotifications;
	//private List<BankAccount> toBeVerifiedAccounts;
	private int indexAccount;
	private BankAccount account;
	private BankClient client;
	private String answer;

	public void verifyAccountTransaction(int index, List<Notification> listNotifications) {
		
		this.listNotifications = listNotifications;
		this.indexAccount = index;
		
		provideDetails();
		
		String error = checkTransactionStructure();
		if( error != null ) printErrorMessage( error );
		else executeTransaction(listNotifications);
	}

	private void provideDetails() {
		
		account = listNotifications.get(indexAccount).clientsAccount;
		client = listNotifications.get(indexAccount).client;
		StdInput input = new StdInput();
		
		System.out.println("Bank Account Details:");
		System.out.println("-------------------- \n");
		System.out.println("Client ID: " + client.clientID);
		System.out.println("Client Name: " + client.name);
		System.out.println("--------------------");
		System.out.println("Account Type: " + account.accountType);
		System.out.println("Account Number: " + account.accountNumber);
		System.out.println("Account Balance: " + account.accountBalance + "\n\n");

		System.out.println( "1. Verify account" );
		System.out.println( "2. Do not verify account" );
		 
		answer = input.read("answer ");	
		
		
	}

	private String checkTransactionStructure() {
		if (answer.equals("1") || answer.equals("2")) return null;
		
		else {
			return "Incorrect option";
		}
	}

	private void printErrorMessage(String error) {

		System.out.println( error );
	}

	private void executeTransaction(List<Notification> listNotifications) {
		if (answer.equals("1")) {
			//toBeVerifiedAccounts.remove(account);
			//verifiedAccounts.add(account);
			
			account.setVerified(true);
			
			System.out.println("Account has been verified");
		}
		
		else {
			//toBeVerifiedAccounts.remove(account);
			System.out.println("Account has been verified");
		}
	}
	
	
	

}
