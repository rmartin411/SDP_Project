package AllFR_SRP;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class BankAdministratorUI {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		List<BankAccount> toBeVerifiedAccounts = new ArrayList<BankAccount>();
		List<BankAccount> VerifiedAccounts = new ArrayList<BankAccount>();

		BankAdministrator admin = new BankAdministrator("Admin", "QUB", new SimpleDateFormat("dd/MM/yyy").parse("12/01/2001"));
		
		BankClient client1 = new BankClient("Ross Martin", "QUB", new SimpleDateFormat("dd/MM/yyy").parse("12/01/2001"), "username1", "password1");
		BankClient client2 = new BankClient("Austin Martin", "BHS", new SimpleDateFormat("dd/MM/yyy").parse("22/08/2004"), "username1", "password1");

		
		BankAccount account = new BankAccount("8765678", "primary", 1234.56);
		BankAccount account1 = new BankAccount("87654567", "savings", 6543.21);
		BankAccount account2 = new BankAccount("5678766", "primary", 0.21);
		BankAccount account3 = new BankAccount("345676678", "savings", 0.0);

		
		client1.bankAccounts.add(account);
		client1.bankAccounts.add(account1);
		
		client2.bankAccounts.add(account2);
		client2.bankAccounts.add(account3);
		
		
		Notification notification = new Notification(client1, admin, new SimpleDateFormat("dd/MM/yyy").parse("12/01/2001"));
		
		
		
		
		
		


	}

}
