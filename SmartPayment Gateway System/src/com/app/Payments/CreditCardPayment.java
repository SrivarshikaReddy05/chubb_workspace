
package com.app.Payments;

import com.app.exceptions.*;
import com.app.interfaces.Refundable;
import com.app.interfaces.Retryable;

public class CreditCardPayment extends Payment implements Refundable, Retryable {

	private boolean validCredentials;

	public CreditCardPayment(double amount, String payer, boolean validCredentials) {
		super(amount, payer);
		this.validCredentials = validCredentials;
	}

	@Override
	public void processPayment() throws InvalidAmountException,InvalidCredentialsException,PaymentGatewayTimeoutException {
		if (amount <= 0) {
			throw new InvalidAmountException("Amount must be positive.");
		}
		if (!validCredentials) {
			throw new InvalidCredentialsException("Invalid card credentials provided.");
		}

		try {
			System.out.println("Processing credit card payment for: " + payer);
			Thread.sleep(500);
			System.out.println("Payment of ₹" + amount + " successful using Credit Card.");
		} catch (InterruptedException e) {
			throw new PaymentGatewayTimeoutException("CreditCard Gateway Timeout");
		}
	}

	@Override
	public void refund(double amount) {
		System.out.println("Refunding ₹" + amount + " to credit card: " + payer);
	}

	@Override
	public void retry() {
		System.out.println("Retrying Credit Card Payment for: " + payer);
	}
}