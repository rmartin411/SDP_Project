package CyberSecurity;

public class Notification {
	
	public BankClient client;
	public BankAccount clientsAccount;
	
	public Notification(BankClient client, BankAccount account) {
		
		this.client = client;
		this.clientsAccount = account;
	}
}
