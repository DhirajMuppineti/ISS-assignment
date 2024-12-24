package main;

public class Main {

    public static void main(String[] args) {
    	SavingsAccount savingsAccount = new SavingsAccount(1, "John Doe", 1000, false);
    	
    	//Savings Account has the behaviours of the Account
    	savingsAccount.displayAccountDetails();
    	
    	//Savings Account specific behaviours
    	savingsAccount.depositAmount(500);
    	savingsAccount.checkBalance();
    	savingsAccount.withdrawAmount(1500);
    	savingsAccount.checkBalance();
    	savingsAccount.withdrawAmount(100); // will show insufficient funds
    }
}
