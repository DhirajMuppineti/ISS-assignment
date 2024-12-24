package main;

public class Main {

    public static void main(String[] args) {
    	Account account = new Account(2, "Jack", 1000, false);
    	DematAccount demat = new DematAccount(1, "John Doe", 1000, false);
    	
    	//Calling parent account's displayAccountDetails
    	account.displayAccountDetails();
    	
    	//Calling the child classes displayAccountDetails
    	demat.displayAccountDetails();
    	
    }
}
