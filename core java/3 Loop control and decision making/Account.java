package main;
//package is a collection of classes

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//a class is a blueprint of a type of entity in our code
//class defines how a certain type of entity behaves and what it stores
public class Account {
	//instance variables are set of data that define the state of that instance/object
	
	//public is an access modifier that means this var is available everywhere
	public int accountNumber; // int is the datatype for integer values. It is signed 32-bit hence the range (-2147483648 to 2147483647)
	
	//private access modifier means it is only available to the class Account.
	private String accountHolderName; // String is an immutable array of characters.
	
	//protected means it can be accessed within the package and all of its subclasses.
	protected float accountBalance; // float means decimal point numbers (32 bit, upto 6-7 after decimal point)
	
	//default access modifier means it can be accessed anywhere in the same package.
	boolean accountDisabled; // boolean can store either true or false.
	
	//static means that this variable belongs to the class not a specific object. There's only one copy in the memory.
	//final means that once assigned it's value cannot change.
	private static final Logger logger = LogManager.getLogger(Account.class);
		
	//methods: Functions that are used to define the behaviour of the object
	
	//constructor: method with the same name as the class. It overrides the default constructors which is empty.
	Account(int accountNumber, String accountHolderName, float accountBalance, boolean accountDisabled){
		//this is a reference to the current object
		//initializing the instance variables using the parameters
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.accountBalance = accountBalance;
		this.accountDisabled = accountDisabled;
	}
	
	public void displayAccountDetails() {
        logger.info("Account Number : " + this.accountNumber);
        logger.info("Account Holder Name : " + this.accountHolderName);
        logger.info("Account Balance : " + this.accountBalance);
        logger.info("Account Disabled : " + (this.accountDisabled ? "Yes" : "No"));
    }
}
