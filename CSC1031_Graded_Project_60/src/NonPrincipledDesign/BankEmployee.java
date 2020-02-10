package NonPrincipledDesign;

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
	public List<Appointments> appointments;
	
	
	public BankEmployee(String name, String address, Date DoB) {
		super(name, address, DoB);
		// TODO Auto-generated constructor stub
		
		this.employeeID = getNextEmployeeID();
		
		appointments = new ArrayList<Appointments>();
		
		
	}
	
	
	public int getNextEmployeeID() {
		int id = nextEmployeeID;
		nextEmployeeID++;
		return id;
	}
	
	
	public static void main(String[] args) {
		
		
	}
	
	public void notify(Appointments app) {
		
		
		
		
		
	}
	
	public static String read( String label ) {

		System.out.println( "\nProvide your " + label + ":" );

		System.out.println( ">" );


		BufferedReader input = new BufferedReader( new InputStreamReader( System.in ) );

		String value = null;

		try {

			value = input.readLine();
		}

		catch (IOException ex) { ex.printStackTrace(); }


		return value;
	}
	
	

}
