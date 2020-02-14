package AllFR_SRP;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BankEmployee extends User{
	
	private static int nextEmployeeID = 1;
	
	public int employeeID;
	public List<Appointment> appointments;
	
	
	public BankEmployee(String name, String address, Date DoB) {
		super(name, address, DoB);
		// TODO Auto-generated constructor stub
		
		this.employeeID = getNextEmployeeID();
		appointments = new ArrayList<Appointment>();
	}
	
	
	public int getNextEmployeeID() {
		int id = nextEmployeeID;
		nextEmployeeID++;
		return id;
	}
	
	
	
	public void notify(Appointment app) {
		
	}
	

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("Bank Employee Details:");
		System.out.println("----------------------\n\n");
		
		System.out.println("Employee ID: " + employeeID);
		System.out.println("Name: " + name);
		System.out.println("Address: " + address);
		System.out.println("Date of Birth: " + DoB.toGMTString());


		

		
		
	}
	
	

}
