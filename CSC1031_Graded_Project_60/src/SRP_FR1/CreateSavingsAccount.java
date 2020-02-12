package SRP_FR1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CreateSavingsAccount extends CreateBankAccount{

	public BankAccount createAccount() {
		// TODO Auto-generated method stub
		
		System.out.println("\n\n===Create Savings account===\n");
		
		String accNum = read("Account number");	
		String accType = read("Account Type");		
		String accBalance = read("Account balance");
		
		BankAccount account = new SavingsAccount(accNum, accType, Double.parseDouble(accBalance));	
		
		return account;
		
	}
	
	public static String read( String label ) {

		System.out.println( "\nProvide your " + label + ":" );

		System.out.println( ">" );


		BufferedReader input = new BufferedReader( new InputStreamReader( System.in ) );

		String value = null;

		try {

			value = input.readLine();
		}

		catch (IOException ex) { ex.printStackTrace(); }


		return value;
	}

}
