package main;


public class Main {
	
    public static void main(String[] args) {
    	DematAccount demat = new DematAccount(1, "Jack", 2000, false);
    	
    	// Directly invests to stocks account balance isn't deducted
    	demat.investStocks(500);
    	demat.displayAccountDetails();
    	
    	// Deduct from balance
    	demat.investStocks(500, true);
    	demat.displayAccountDetails();
    	
    	// Runtime polymorphism
    	Account[] accounts = {new Account(1, "Alice", 2000, false), new SavingsAccount(2, "Bob", 3000, false), new DematAccount(3, "Charlie", 4000, false)};
        // Each account behaving differently at runtime
    	for (Account account : accounts) {
    		account.displayAccountDetails();
    	}
    }
}
