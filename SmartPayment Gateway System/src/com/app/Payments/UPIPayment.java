
package com.app.Payments;

import com.app.exceptions.*;
import com.app.interfaces.Retryable;

public class UPIPayment extends Payment implements Retryable {

	private boolean correctPin;

	public UPIPayment(double amount, String payer, boolean correctPin) {
		super(amount, payer);
		this.correctPin = correctPin;
	}

	@Override
	public void processPayment() throws InvalidAmountException,InvalidCredentialsException {
		if (amount <= 0) {
			throw new InvalidAmountException("UPI payment amount cannot be negative or zero.");
		}
		if (!correctPin) {
			throw new InvalidCredentialsException("Incorrect UPI PIN.");
		}

		System.out.println("Processing UPI payment for: " + payer);
		System.out.println("UPI Payment of ₹" + amount + " successful.");
	}

	@Override
	public void retry() {
		System.out.println("Retrying UPI payment for: " + payer);
	}
}