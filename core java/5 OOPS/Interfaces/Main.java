package main;


public class Main {
	
    public static void main(String[] args) {
 
    	//Account acc = new Account() will throw error as interfaces cannot be instantiated
    	
    	SavingsAccount account = new SavingsAccount(1, "John Doe", 4000, false);
    	account.displayAccountDetails();
    	
    	DematAccount demat = new DematAccount(2,"Alice", 5000, false);
    	demat.displayAccountDetails();
    	
    }
}
