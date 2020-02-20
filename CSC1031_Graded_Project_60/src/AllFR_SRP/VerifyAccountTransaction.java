package AllFR_SRP;

import java.util.List;

public class VerifyAccountTransaction {
	
	private List<Notification> listNotifications;
	private List<BankAccount> toBeVerifiedAccounts;
	private int indexAccount;
	private BankAccount account;
	private String answer;

	public void verifyAccountTransaction(int index, List<BankAccount> toBeVerifiedAccounts,
			List<BankAccount> verifiedAccounts) {
		
		this.toBeVerifiedAccounts = toBeVerifiedAccounts;
		this.indexAccount = index;
		
		provideDetails();
		
		String error = checkTransactionStructure();
		if( error != null ) printErrorMessage( error );
		else executeTransaction(toBeVerifiedAccounts, verifiedAccounts);
	}

	private void provideDetails() {
		
		account = toBeVerifiedAccounts.get(indexAccount);
		StdInput input = new StdInput();
		
		//String clientName = account.accountType;
		String accountType = account.accountType;
		int accountNumber = account.accountNumber;
		double accoutBalance = account.accountBalance;

		System.out.println("Bank Account Details:");
		System.out.println("-------------------- \n");
		//System.out.println("Client Name: " + clientName);
		System.out.println("Account Type: " + accountType);
		System.out.println("Account Number: " + accountNumber);
		System.out.println("Account Balance: " + accoutBalance + "\n\n");

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

	private void executeTransaction(List<BankAccount> toBeVerifiedAccounts, List<BankAccount> verifiedAccounts) {
		if (answer.equals("1")) {
			toBeVerifiedAccounts.remove(account);
			verifiedAccounts.add(account);
			
			account.setVerified(true);
			
			System.out.println("Account has been verified");
		}
		
		else {
			toBeVerifiedAccounts.remove(account);
			System.out.println("Account has been verified");
		}
	}
	
	
	

}
