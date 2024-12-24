package main;


// abstract class because the implementation of displayAccountDetails isn't provided here
public abstract class Account {
	
	public int accountNumber; 
	
	protected String accountHolderName; 
	
	protected float accountBalance;

	boolean accountDisabled; 
	

	public abstract void displayAccountDetails();
}
