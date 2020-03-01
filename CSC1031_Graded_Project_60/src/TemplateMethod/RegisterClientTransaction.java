package TemplateMethod;

import java.text.ParseException;
import java.util.List;

public interface RegisterClientTransaction  {
	
	public abstract void registerNewClient(List<BankClient> clients) throws ParseException;

}
