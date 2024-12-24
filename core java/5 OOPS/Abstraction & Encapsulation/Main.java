package main;


public class Main {
	
    public static void main(String[] args) {
    	//Abstraction 
    	//Account acc = new Account() will throw error as abstract classes cannot be instantiated
    	SavingsAccount account = new SavingsAccount(1, "John Doe", 4000, false);
    	account.displayAccountDetails();
    	//Encapsulation
    	DematAccount demat = new DematAccount(2,"Alice", 5000, false);
    	// demat.stockAmount can't be accessed directly 
    	//checking current stock amount
    	demat.displayAccountDetails();
    	//investing 500 in stocks
    	demat.investStocks(500);
    	demat.displayAccountDetails();
    }
}
