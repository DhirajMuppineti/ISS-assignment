package main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
	
	private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
    	// Creating an instance of the Account class
        Account account1 = new Account(1, "Jack", 10000, false);
        
        String accountStatus;
        
        // using if-else if-else statements
        if (account1.accountDisabled) {
            accountStatus = "disabled";
        } else if (account1.accountBalance == 0) {
            accountStatus = "empty";
        } else {
            accountStatus = "active";
        }

        // Using switch logic
        switch (accountStatus) {
            case "disabled":
                logger.error("Your account is disabled. Please contact support.");
                break;
            case "empty":
                logger.warn("Your account balance is empty. Please deposit funds.");
                break;
            case "active":
                logger.info("Your account is active and has a sufficient balance.");
                break;
            default:
                logger.error("Unknown account status.");
                break;
        }
        
        //for loop
        String star = "";
        
        for(int i = 0; i < 5; i++) {
        	star += "*";
        	logger.info(star);
        }
        
        //while loop
        star = "";
        int i = 0;
        while (i < 5) {
        	star += "*";
        	logger.info(star);
        	i += 1;
        }
        
        //do-while loop
        star = "";
        i = 0;
        do{
        	star += "*";
        	logger.info(star);
        	i += 1;
        }while(i < 5);    
    }
}
