package CyberSecurity;

public abstract class User {
	
	public String name;
		
	public User(String name) { 
		this.name = name;
	}
	
	public abstract void print();

}
