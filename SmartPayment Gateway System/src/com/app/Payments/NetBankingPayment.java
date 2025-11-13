
package com.app.Payments;

import com.app.exceptions.*;
import com.app.interfaces.Retryable;

public class NetBankingPayment extends Payment implements Retryable {

	private boolean credentialsValid;

	public NetBankingPayment(double amount, String payer, boolean credentialsValid) {
		super(amount, payer);
		this.credentialsValid = credentialsValid;
	}

	@Override
	public void processPayment() throws InvalidAmountException,InvalidCredentialsException {
		if (amount <= 0) {
			throw new InvalidAmountException("Invalid payment amount.");
		}
		if (!credentialsValid) {
			throw new InvalidCredentialsException("Invalid bank login credentials.");
		}

		System.out.println("Processing NetBanking payment for: " + payer);
		System.out.println("NetBanking payment of ₹" + amount + " successful.");
	}

	@Override
	public void retry() {
		System.out.println("Retrying NetBanking payment for: " + payer);
	}
}