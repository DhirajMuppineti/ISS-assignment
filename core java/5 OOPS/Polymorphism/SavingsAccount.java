package main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//Inheritance is the concept of reusing the code of one class into other
//SavingsAccount inherits everything from Account
//SavingsAccount is-a Account
public class SavingsAccount extends Account {
	
	private static final Logger logger = LogManager.getLogger(SavingsAccount.class);
	//Using the super class constructor for this class
	public SavingsAccount(int accountNumber, String accountHolderName, float accountBalance, boolean accountDisabled) {
		super(accountNumber, accountHolderName, accountBalance, accountDisabled);
	}
	
	//Behaviors specific to SavingsAccount
	public void depositAmount(int amount) {
		this.accountBalance += amount;
	}
	
	public void withdrawAmount(int amount) {
		if(this.accountBalance - amount < 0)
			logger.error("Insufficient funds!!");
		
		this.accountBalance -= amount;
	}
	
	public void checkBalance() {
		logger.info(this.accountBalance);
	}

}
