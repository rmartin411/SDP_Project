package AllFR_OCP;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public abstract class CreateClientProfileTransaction {
	
	protected String name;
	protected String address;
	protected String DoB;
	
	public abstract void createClientProfile(BankClient clientLoggedIn) throws ParseException;

}
