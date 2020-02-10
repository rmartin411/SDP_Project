package NonPrincipledDesign;

import java.util.List;

public class BankAccount {
	
	public String accountNumber;
	public String accountType;
	public double accountBalance;
	
	public BankAccount(String accountNum, String accountType, double balance) {
		this.accountNumber = accountNum;
		this.accountType = accountType;
		this.accountBalance = balance;
	}
	
	public void setAccountBalance(double balance) {
		this.accountBalance = balance;
	}

}
