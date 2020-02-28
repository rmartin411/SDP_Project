package part02;

import java.util.List;

public class CreateBankAccountTransaction {
	
	public String accountType;
	public double accountBalance;
	
	String accountBalanceStr;
	
	
	public void createNewBankAccount(List<BankAccount> accounts) {
		
		provideAccountDetails();
		
		String error = checkTransactionStructure();
		
		if( error != null ) printErrorMessage( error );

		else executeCreateAccountTransaction( accounts );
		
		
	}

	
	public void printErrorMessage(String error) {

		System.out.println( error );
	}

	private void provideAccountDetails() {

		StdInput object = new StdInput();
		
		accountType = object.read("account type");
		accountBalanceStr = object.read("account balance");
	}
	
	
	public String checkTransactionStructure() {

		if( accountType == null || (accountType.equals("savings") == false && accountType.equals("primary") == false)) return "Error account type";

		if (accountBalanceStr != null) {
			if (accountBalanceStr.matches("([0-9]*)\\.([0-9]*)")) {
				
				accountBalance = Double.parseDouble(accountBalanceStr);				
			}
			else {
				return "Error account balance";
			}
		}
		else {
			accountBalance = 0.0;

		}

		return null;
	}
	
	private void executeCreateAccountTransaction(List<BankAccount> accounts) {

		BankAccount account = null;
		
		if (accountType.equals("primary")) {
			account = new PrimaryAccount(accountType, accountBalance);
		}
		else {
			account = new SavingsAccount(accountType, accountBalance);
		}
		
		accounts.add(account);
	}
	

}
