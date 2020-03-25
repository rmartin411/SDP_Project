package SingletonPatternTEST;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


public class BankClient extends User{
	
	public static final AtomicInteger clientCount = new AtomicInteger(0);
	public String test;
	private static int nextClientID = 1;
	
	public int clientID;

	public String username;
	public String password;
	
	public String address;
	public Date DoB;
	
	public List<BankAccount>bankAccounts;
	
	public List<Appointment> bookedAppointments;
	public List<Appointment> ScheduledAppointments;
	
	
	// Constructor
	public BankClient(String name, String address, Date DoB, String username, String password) {
		
		super(name);
		
		this.clientID = getNextClientID();
		//this.name = name;
		this.address = address;
		this.DoB = DoB;
		this.username = username;
		this.password = password;
		
		bankAccounts = new ArrayList<BankAccount>();
		
		bookedAppointments = new ArrayList<Appointment>();
		ScheduledAppointments = new ArrayList<Appointment>();
		
		
		clientCount.incrementAndGet();	
	}
	
	public BankClient(String username, String password) { // used on registration
		// TODO Auto-generated constructor stub
		
		super("");
		
		this.clientID = getNextClientID();

		this.username = username;
		this.password = password;
		
		bankAccounts = new ArrayList<BankAccount>();
		bookedAppointments = new ArrayList<Appointment>();
		ScheduledAppointments = new ArrayList<Appointment>();
		
		clientCount.incrementAndGet();
	}
	
	public BankClient(String name, String address, Date DoB) { // used on profile creation
		super(name);
		
		this.address = address;
		this.DoB = DoB;
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
	
	public void addAppointment(Date appointmentDate, BankEmployee Employee) {
		if (appointmentDate != null & Employee != null) {
			
			Appointment appointment = new Appointment(appointmentDate, Employee, this, false);
			
			bookedAppointments.add(appointment);
			
			//BankEmployee.notify(appointment);
		}
	}
	
	@Override
	public void print() {
		
		System.out.println("Bank Client Details:");
		System.out.println("----------------------\n\n");
		
		System.out.println( "Client ID = " + clientID + ", Name = " + name + "\n\nAddress = " + address + ", Date of Birth = " + DoB + ", Username = " + username);

		if (bankAccounts != null) {
			for (int i = 0; i <bankAccounts.size(); i++) { // iterate through list of their accounts
				System.out.println( "\tAccount Number = " + bankAccounts.get(i).accountNumber); 
				System.out.println( "\tAccount Type = " + bankAccounts.get(i).accountType); 
				System.out.println( "\tAccount Balance = " + bankAccounts.get(i).accountBalance + "\n\n"); 
			}	
		}
	}

	public void setProfileDetails(String name, String address, Date DoB) {
		this.name = name;
		this.address = address;
		this.DoB = DoB;
	}
}
