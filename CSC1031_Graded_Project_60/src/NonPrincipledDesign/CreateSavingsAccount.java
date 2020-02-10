package NonPrincipledDesign;

public class CreateSavingsAccount extends CreateBankAccount{

	@Override
	public void createAccount() {
		// TODO Auto-generated method stub
		
		System.out.println("\n\n===Create Savings account===\n");
		
		String accNum = read("Account number");	
		String accType = read("Account Type");		
		String accBalance = read("Account balance");		
		
		clientLoggedIn.accountNumbers.add(accNum);
		clientLoggedIn.accountTypes.add(accType);
		clientLoggedIn.accountBalances.add(Double.parseDouble(accBalance));
		
	}

}
