package AllFR_OCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.List;

public interface RegisterClientTransaction  {
	
	public abstract void registerNewClient(List<BankClient> clients) throws ParseException;

}
