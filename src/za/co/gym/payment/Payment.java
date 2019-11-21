package za.co.gym.payment;

public class Payment {
	private double amount;
	private double balance;

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getBalace() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double cashPayment(double amount, int duration) {

		this.amount = amount;

		setBalance(this.amount - (duration * 200));

		return this.balance;

	}

}
