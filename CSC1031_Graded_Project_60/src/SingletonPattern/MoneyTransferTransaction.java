package SingletonPattern;

public class MoneyTransferTransaction  {
	
	public String withdrawAccountNum;
	public String depositAccountNum;
	public String amountToTransfer;
	
	public BankClient client;
	
	public int withdrawAccountIndex = -1;
	public int depositAccountIndex;
	
	public void makeMoneyTransfer(BankClient clientLoggedIn) {
		
		client = clientLoggedIn;
		
		provideTransferDetails();
		
		String error = checkTransactionStructure();
		
		if( error != null ) printErrorMessage( error );

		else executeMoneyTransferTransaction( clientLoggedIn );
		
	}

	public void provideTransferDetails() {
		
		System.out.println("\n\n=== Transfer Money ===\n");

		StdInput object = new StdInput();
		
		ListPrint.printBankAccounts(client);
		
		withdrawAccountNum = object.read("withdrawal account number");	
		depositAccountNum = object.read("deposited account number");		
		amountToTransfer = object.read("amount to transfer");
		
	}

	public String checkTransactionStructure() {
		
		boolean depositAccount = false;
		
		if (Double.parseDouble(amountToTransfer) <0.0) return "Transfer amount must be positive";
		
		for (int wAccount = 0; wAccount < client.bankAccounts.size(); wAccount++) {
			
			if (client.bankAccounts.get(wAccount).accountNumber == Integer.parseInt(withdrawAccountNum)) { // check account belongs to client
				
				withdrawAccountIndex = wAccount;
				break;
			}
		}
		if (withdrawAccountIndex == -1 ) {
			return "Account to withdraw from not found";
		}

		double balance = client.bankAccounts.get(withdrawAccountIndex).accountBalance; // get the balance of withdrawal account
				
		if (balance >= Double.parseDouble(amountToTransfer)) { // check the user has enough money in their account
			for (int dAccount = 0; dAccount < client.bankAccounts.size(); dAccount++) {
				
				if (client.bankAccounts.get(dAccount).accountNumber== Integer.parseInt(depositAccountNum)) { // check deposit account belongs to user 
								
					depositAccountIndex = dAccount;
					depositAccount = true;
					return null;
				}
			}
			if (depositAccount == false) return "Account to deposit to not found";
		
		}
		else {
			return "Insufficient funds to make transfer";
		}
		
		return "Money Transfer could not take place";
					
		
	}

	public void printErrorMessage(String error) {
		// TODO Auto-generated method stub
		System.out.println(error);
	}

	private void executeMoneyTransferTransaction(BankClient client) {
		
		client.bankAccounts.get(withdrawAccountIndex).setAccountBalance(client.bankAccounts.get(withdrawAccountIndex).accountBalance-Double.parseDouble(amountToTransfer)); // if it does then decrease balance by the amount
		client.bankAccounts.get(depositAccountIndex).setAccountBalance(client.bankAccounts.get(depositAccountIndex).accountBalance+Double.parseDouble(amountToTransfer)); // and increase deposited account by the same amount
		
		client.print();
	}
}
