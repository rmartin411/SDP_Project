package part02;

import java.text.ParseException;

public interface  CreateClientProfileTransaction {
	
	public abstract void createClientProfile(BankClient clientLoggedIn) throws ParseException;

}
