package main;

public class Main {

    public static void main(String[] args) {
        //Creating an instance of the Account class
    	Account account1 = new Account(1, "Jack", 1000, false);
    	
    	//we can create as many instances as we want
    	//Creating another instance of the class
    	Account account2 = new Account(2, "Jill", 2999, false);
    	
    	//Using methods to interact with the class
    	account1.displayAccountDetails();
    	account2.displayAccountDetails();
    }

}
