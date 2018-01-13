
public class Account {
	private double balance;
	
	public Account(double initBalance) {
		balance=initBalance;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setAmount(double amt) {
		balance = amt;
	}
	
	public void deposit(double amt) {
		balance += amt;
		//balance = balance + amt;
	}
	
	public void withdraw(double amt) {
		if (amt>balance) {
			System.out.println("Usted solo pudo retirar: " + (amt - balance));
			balance=0;
		}
		else {
			balance-= amt;
			
		}
	}
	
}
