package SingletonPattern;

import java.util.List;

public class VerifyAccountTransaction {
	
	private List<Notification> listNotifications;
	//private List<BankAccount> toBeVerifiedAccounts;
	private int index;
	private BankAccount account;
	private BankClient client;
	private String answer;

	public void verifyAccountTransaction(int index, List<Notification> listNotifications) {
		
		this.listNotifications = listNotifications;
		this.index = index;
		
		provideDetails();
		
		String error = checkTransactionStructure();
		if( error != null ) printErrorMessage( error );
		else executeTransaction(listNotifications);
	}

	private void provideDetails() {
		
		account = listNotifications.get(index).clientsAccount;
		client = listNotifications.get(index).client;
				
		StdInput input = new StdInput();
		
		System.out.println("ClientID: " + client.clientID + " Account Number: " + account.accountNumber);

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
			
			System.out.println("Account " + account.accountNumber + " has been verified \n");
		}
		
		else {
			//toBeVerifiedAccounts.remove(account);
			System.out.println("Account " + account.accountNumber + " has not been verified\n");
		}
	}
	
	
	

}
