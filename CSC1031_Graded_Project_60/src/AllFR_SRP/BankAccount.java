package AllFR_SRP;

import java.util.List;

public class BankAccount {
	
	public String accountNumber;
	public String accountType;
	public double accountBalance;
	
	public boolean verified;
	
	public BankAccount(String accountNum, String accountType, double balance) {
		this.accountNumber = accountNum;
		this.accountType = accountType;
		this.accountBalance = balance;
		
		this.verified = false;
	}
	
	public void setAccountBalance(double balance) {
		this.accountBalance = balance;
	}

}
