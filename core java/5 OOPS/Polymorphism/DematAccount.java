package main;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DematAccount extends SavingsAccount {
	
	private int dematID;
	private int stockAmount;
	
	private static final Logger logger = LogManager.getLogger(DematAccount.class);

	public DematAccount(int accountNumber, String accountHolderName, float accountBalance, boolean accountDisabled) {
		super(accountNumber, accountHolderName, accountBalance, accountDisabled);
		
		Random random = new Random();
		this.dematID = random.nextInt(1000000, 10000000);
		this.stockAmount = 0;
	}
	
	//Overriding the parent class's method
	@Override
	public void displayAccountDetails() {
        logger.info("Account Number : " + this.accountNumber);
        logger.info("Account Holder Name : " + this.accountHolderName);
        logger.info("Account Balance : " + this.accountBalance);
        logger.info("Account Disabled : " + (this.accountDisabled ? "Yes" : "No"));
        logger.info("Demat ID : " + this.dematID);
        logger.info("Amount in stocks : " + this.stockAmount);
    }
	
	//Compile time polymorphism, different defintions of the same function
	
	//Directly invest money to stocks
	public void investStocks(int amount) {
		this.stockAmount += amount;
	}
	
	//Check if want to invest from account balance
	public void investStocks(int amount, boolean fromBalance) {
		if(fromBalance) {
			if(this.accountBalance - amount < 0)
				logger.error("Insufficient funds!!");
			
			this.accountBalance -= amount;
			this.stockAmount += amount;
		}else{
			this.stockAmount += amount;
		}
	}
}
