package SingletonPattern;

import java.text.ParseException;

public interface  CreateClientProfileTransaction {
	
	public abstract void createClientProfile(BankClient clientLoggedIn) throws ParseException;

}
