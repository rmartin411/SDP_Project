package SRP_FR1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


public class BankClient extends User{
	
	public static final AtomicInteger clientCount = new AtomicInteger(0);
	
	private static int nextClientID = 1;
	
	public int clientID;

	public String username;
	public String password;
	
	public List<BankAccount>bankAccounts;
	
	public List<Appointments> bookedAppointments;
	public List<Appointments> ScheduledAppointments;
	
	
	// Constructor
	public BankClient(String name, String address, Date DoB, String username, String password) {
		
		super(name, address, DoB);
		
		this.clientID = getNextClientID();
		//this.name = name;
		//this.address = address;
		//this.DoB = DoB;
		this.username = username;
		this.password = password;
		
		bankAccounts = new ArrayList<BankAccount>();
		
		bookedAppointments = new ArrayList<Appointments>();
		ScheduledAppointments = new ArrayList<Appointments>();

		
		
	}
	
	public int getNextClientID() {
		int id = nextClientID;
		nextClientID++;
		return id;
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
	
	public void changeCientDetails(String name, String address, Date DoB, String username, String password) {
		this.name = name;
		this.address = address;
		this.DoB = DoB;
		
		this.username = username;
		this.password = password;
	}
	
	public void addAccount(String accountNumber, String accountType, double balance) {
		
		if (accountNumber != null && accountType != null && balance >= 0.0) {
			
			BankAccount account = new SavingsAccount( accountNumber, accountType, balance);
			bankAccounts.add(account);
			
		}	
	}
	
	
	
	public void addAppointment(Date appointmentDate, BankEmployee Employee) {
		if (appointmentDate != null & Employee != null) {
			
			Appointments appointment = new Appointments(appointmentDate, Employee, this);
			
			bookedAppointments.add(appointment);
			
			//BankEmployee.notify(appointment);
			
		}
	}
	
	
	public void makeTransfer(String withdrawAccountNum, String depositAccountNum, String amountToTransfer) {
		
		for (int wAccount = 0; wAccount < bankAccounts.size(); wAccount++) {
			
			
			
			if (bankAccounts.get(wAccount).accountNumber.equals(withdrawAccountNum)) { // check account belongs to client
				
				double balance = bankAccounts.get(wAccount).accountBalance; // get the balance of withdrawal account
				
				if (balance >= Double.parseDouble(amountToTransfer)) { // check the user has enough money in their account
					
					for (int dAccount = 0; dAccount < bankAccounts.size(); dAccount++) {
						
						if (bankAccounts.get(wAccount).accountNumber.equals(depositAccountNum)) { // check deposit account belongs to user 
									
							bankAccounts.get(wAccount).setAccountBalance(balance-Double.parseDouble(amountToTransfer)); // if it does then decrease balance by the amount
							bankAccounts.get(dAccount).setAccountBalance(bankAccounts.get(dAccount).accountBalance+Double.parseDouble(amountToTransfer)); // and increase deposited account by the same amount
						}	
					}	
				}
				else {
					System.out.println("Insufficient funds - transfer can not be made");
				}
			}
		}		
	}
	
	public void deleteBankAccount(String accountNumber) { // any remaining funds will be transfered to another account
		
		List<BankAccount> newListBankAccounts = new ArrayList<BankAccount>(); 
		
		int index = 0;
		
		for(int account = 0; account< bankAccounts.size(); account++) { // get index of account to be deleted
			if (bankAccounts.get(account).accountNumber.equals(accountNumber)) {
				index = account;
			}
		}
		
		for ( int accUntil = 0; accUntil < index; accUntil++) { // for every account before the account to be deleted add it to a temp array
			newListBankAccounts.add(bankAccounts.get(accUntil));
		}
		
		for (int accAfter = index+1; accAfter < bankAccounts.size(); accAfter++) { // skip array to be deleted and add the rest of the account details to their respective arraylists
			newListBankAccounts.add(bankAccounts.get(accAfter));
		}
		
		// overwrite old arraylists with new arraylist without the account that was deleted
		bankAccounts = newListBankAccounts; 
		
	}
	
	public void toPrint() {

		System.out.println( "Client ID = " + clientID + ", Name = " + name + "\n\nAddress = " + address + ", Date of Birth = " + DoB + ", Username = " + username);

		if (bankAccounts != null) {
			for (int i = 0; i <bankAccounts.size(); i++) { // iterate through list of their accounts
				System.out.println( "\tAccount Number = " + bankAccounts.get(i).accountNumber); 
				System.out.println( "\tAccount Type = " + bankAccounts.get(i).accountType); 
				System.out.println( "\tAccount Balance = " + bankAccounts.get(i).accountBalance + "\n\n"); 
			}	
		}
	}
	
	


	
	
	
	

}
