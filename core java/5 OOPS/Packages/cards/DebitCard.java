package cards;
//package are a collection of related classes

import main.SavingsAccount;

public class DebitCard {
	SavingsAccount account;
	public DebitCard(SavingsAccount account) {
		this.account = account;
	}
	
	public void withdraw(int amount) {
		this.account.withdrawAmount(amount);
	}

}
