package NonPrincipledDesign;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


public class BankClient {
	
	public static final AtomicInteger clientCount = new AtomicInteger(0);
	
	private static int nextClientID = 1;
	
	public int clientID;
	public String name;
	public String address;
	public Date DoB;
	
	public String username;
	public String password;
	
	public List<String> accountNumbers;
	public List<String> accountTypes;
	public List<Double> accountBalances;
	
	public List<Date> appointments;
	public List<BankEmployee> bankEmployee;
	
	
	// Constructor
	public BankClient(String name, String address, Date DoB, String username, String password) {
		
		this.clientID = getNextClientID();
		this.name = name;
		this.address = address;
		this.DoB = DoB;
		this.username = username;
		this.password = password;
	}
	
	public int getNextClientID() {
		int id = nextClientID;
		nextClientID++;
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setDoB(Date DoB) {
		this.DoB = DoB;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public String getAddress() {
		return address;
	}
	public Date getDoB() {
		return DoB;
	}
	public String getUsername() {
		return username;
	}
	public String getpassword() {
		return password;
	}
	
	public void addAccount(String accountNumber, String accountType, double balance) {
		
		if (accountNumber != null && accountType != null && balance >= 0.0) {
			accountNumbers.add(accountNumber);
			accountTypes.add(accountType);
			accountBalances.add(balance);
		}	
	}
	
	public void addAppointment(Date appointmentDate, BankEmployee Employee) {
		if (appointmentDate != null & Employee != null) {
			appointments.add(appointmentDate);
			bankEmployee.add(Employee);
		}
	}
	
	public void toPrint() {

		System.out.println( "Client ID = " + clientID + ", Name = " + name + "\n\nAddress = " + address + ", Date of Birth = " + DoB + ",Username = " + username);


		if (accountNumbers != null) {
			for (int i = 0; i <accountNumbers.size(); i++) { // iterate through list of their accounts
				System.out.println( "\tAccount Number = " + accountNumbers.get(i)); 
				System.out.println( "\tAccount Type = " + accountTypes.get(i)); 
				System.out.println( "\tAccount Number = " + accountBalances.get(i) + "\n\n"); 
			}	
		}
	}
	
	


	
	
	
	

}
