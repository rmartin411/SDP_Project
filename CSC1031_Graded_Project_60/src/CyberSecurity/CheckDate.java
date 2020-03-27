package CyberSecurity;

import java.util.Date;

public class CheckDate {
	private Date date;

	public CheckDate(Date date) {
		boolean initialised = checkUserDate(date);
		
		if (initialised) init (date);
		else throw new SecurityException ("Security Exception thrown");
	}

	private void init(Date date) {
		this.date = date;
	
	}

	private boolean checkUserDate(Date date) {
		
		Date currentDate = new Date();
		System.out.println("current date: " + currentDate);
	    
	    if(date.compareTo(currentDate) > 0) return false;
	
		return true;
	}

}
