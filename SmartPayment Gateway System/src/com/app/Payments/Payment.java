
package com.app.Payments;

public abstract class Payment {
	protected double amount;
	protected String payer;

	public Payment(double amount, String payer) {
		this.amount = amount;
		this.payer = payer;
	}

	public abstract void processPayment() throws Exception;
}