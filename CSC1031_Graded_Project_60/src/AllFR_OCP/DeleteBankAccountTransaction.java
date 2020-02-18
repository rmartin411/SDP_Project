package AllFR_OCP;

import java.util.ArrayList;
import java.util.List;

public class DeleteBankAccountTransaction  {
	
	public String accountNumberProvided;
	public BankClient client;
	
	
	
	public void deleteBankAccount(BankClient clientLoggedIn) {
		
		client = clientLoggedIn;
		
		provideAccountNumber();
		
		String error = checkTransactionStructure();
		
		if( error != null ) printErrorMessage( error );

		else executeDeleteAccountTransaction( clientLoggedIn );
	}

	private void provideAccountNumber() {
		// TODO Auto-generated method stub
		System.out.println("\n\n=== Delete a bank account ===\n");
				
		StdInput object = new StdInput();
		
		accountNumberProvided = object.read(" account number of the account to delete");
		
	}
	
	public String checkTransactionStructure() {
		// TODO Auto-generated method stub
		
		String status = "";
		int count = 0;
		
		for(int account = 0; account < client.bankAccounts.size(); account++) { // get index of account to be deleted
			
			if (client.bankAccounts.get(account).accountNumber == Integer.parseInt(accountNumberProvided)) {
				status = null;
				return status;
			}
			
			count++;
		}
		
		if (count == client.bankAccounts.size() - 1) {
			status = "No account Found";
			return status;
		}
		
		return status;
		
	}

	public void printErrorMessage(String error) {
		System.out.println( error );
	}

	private void executeDeleteAccountTransaction(BankClient clientLoggedIn) {
		// TODO Auto-generated method stub
		
		List<BankAccount> newListBankAccounts = new ArrayList<BankAccount>(); 
		
		int index = 0;
		
		for(int account = 0; account< clientLoggedIn.bankAccounts.size(); account++) { // get index of account to be deleted
			if (clientLoggedIn.bankAccounts.get(account).accountNumber == Integer.parseInt(accountNumberProvided)) {
				index = account;
			}
		}
		
		for ( int accUntil = 0; accUntil < index; accUntil++) { // for every account before the account to be deleted add it to a temp array
			newListBankAccounts.add(clientLoggedIn.bankAccounts.get(accUntil));
		}
		
		for (int accAfter = index+1; accAfter < clientLoggedIn.bankAccounts.size(); accAfter++) { // skip array to be deleted and add the rest of the account details to their respective arraylists
			newListBankAccounts.add(clientLoggedIn.bankAccounts.get(accAfter));
		}
		
		// overwrite old arraylists with new arraylist without the account that was deleted
		clientLoggedIn.bankAccounts = newListBankAccounts;
		
	}

}
