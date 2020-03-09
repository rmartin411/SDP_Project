package SingletonPattern;

import java.text.ParseException;

public abstract class TransactionTemplate {
	public void transaction() throws ParseException{
		provideDetails();
		String error = checkTransaction();
		if( error != null ) printErrorMessage( error );
		else executeTransaction();
	}
	
	abstract void provideDetails();
	abstract String checkTransaction() throws ParseException;
	abstract void printErrorMessage(String message);
	abstract void executeTransaction();
}