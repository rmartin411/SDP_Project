package AllFR_OCP;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class BankAccount { // should this be abstract 
	
	public static final AtomicInteger accountNum = new AtomicInteger(0);

	public int accountNumber;
	public String accountType;
	public double accountBalance;
	
	public boolean verified;
	
	public BankAccount(String accountType, double balance) {
		this.accountNumber = accountNum.incrementAndGet();
		this.accountType = accountType;
		this.accountBalance = balance;
		
		this.verified = false;
	}
	
	public void setAccountBalance(double balance) {
		this.accountBalance = balance;
	}

}
