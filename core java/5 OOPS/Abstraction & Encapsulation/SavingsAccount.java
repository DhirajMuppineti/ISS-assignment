package main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SavingsAccount extends Account {
	
	private static final Logger logger = LogManager.getLogger(SavingsAccount.class);

	public SavingsAccount(int accountNumber, String accountHolderName, float accountBalance, boolean accountDisabled) {
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.accountBalance = accountBalance;
		this.accountDisabled = accountDisabled;
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
	//providing the implementation here
	@Override
	public void displayAccountDetails() {
        logger.info("Account Number : " + this.accountNumber);
        logger.info("Account Holder Name : " + this.accountHolderName);
        logger.info("Account Balance : " + this.accountBalance);
        logger.info("Account Disabled : " + (this.accountDisabled ? "Yes" : "No"));
	}
}
