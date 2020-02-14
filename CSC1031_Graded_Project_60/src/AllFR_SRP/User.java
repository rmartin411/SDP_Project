package AllFR_SRP;

import java.util.Date;

public abstract class User {
	
	public String name;
	public String address;
	public Date DoB;
	
	public User(String name, String address, Date DoB) {
		this.name = name;
		this.address = address;
		this.DoB = DoB;
	}
	
	public abstract void print();

}
