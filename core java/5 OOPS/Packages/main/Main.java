package main;

import cards.DebitCard; //importing from another package

public class Main {
	
    public static void main(String[] args) {
    	SavingsAccount account = new SavingsAccount(1, "Alice", 5000, false);
    	DebitCard card = new DebitCard(account);
    	
    	//withdrawing using card
    	card.withdraw(500);
    	account.checkBalance();
    }
}
