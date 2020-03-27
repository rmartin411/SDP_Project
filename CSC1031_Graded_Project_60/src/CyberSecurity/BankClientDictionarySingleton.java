package CyberSecurity;

import java.util.ArrayList;
import java.util.List;

public class BankClientDictionarySingleton {
	
	private static BankClientDictionarySingleton theInstance;
	
	private BankClientDictionarySingleton() {};
	
	public static BankClientDictionarySingleton getInstance() {
		
		if (theInstance == null) {
			theInstance = new BankClientDictionarySingleton();
			
			
		}
		
		return theInstance;
	}
	
	private List<BankClient> bankClients;
	
	public void addBankClient( BankClient bankClient ) {
		
		if (bankClients == null) bankClients = new ArrayList<BankClient>();
		
		bankClients.add(bankClient);
		
	}
	
    public void printBankClients() {
    	
    	if (bankClients != null) {
    		for(int client = 0; bankClients != null & client < bankClients.size(); client++) {
    			bankClients.get(client).print();
    		}
    	}
    }
    
    public int searchBankClient( String username, String password ) {
    	int pos = -1;
    	
    	for(int client = 0; bankClients != null & client < bankClients.size(); client++) {
    		BankClient cli = bankClients.get(client);
    		if (cli.username.equals(username) && cli.password.equals(password)) pos = client;
    	}

		return pos;
    	
    }
    public int size() {
		return bankClients.size();	
    }
    
    public BankClient get( int pos ) {
    	    	
    	for(int client = 0; bankClients != null & client < bankClients.size(); client++) {
    		if (client == pos) return bankClients.get(client) ;
    	}
		return null;
    }
    
    public void delete(int id) {
    	for(int client = 0; bankClients != null & client < bankClients.size(); client++) {
    		BankClient cli = bankClients.get(client);
    		if (cli.clientID == id) bankClients.remove(cli) ;
    	}
    }
}
