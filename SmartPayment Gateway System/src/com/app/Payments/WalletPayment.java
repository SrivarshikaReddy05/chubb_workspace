
package com.app.Payments;

import com.app.exceptions.*;
import com.app.interfaces.Refundable;

public class WalletPayment extends Payment implements Refundable {

	private double walletBalance;

	public WalletPayment(double amount, String payer, double walletBalance) {
		super(amount, payer);
		this.walletBalance = walletBalance;
	}

	@Override
	public void processPayment() throws InvalidAmountException,InsufficientBalanceException {
		if (amount <= 0) {
			throw new InvalidAmountException("Wallet payment amount invalid.");
		}
		if (walletBalance < amount) {
			throw new InsufficientBalanceException("Insufficient balance in wallet.");
		}

		System.out.println("Wallet payment of ₹" + amount + " successful for: " + payer);
	}

	@Override
	public void refund(double amount) {
		walletBalance += amount;
		System.out.println("Refunded ₹" + amount + " to wallet. Current balance: ₹" + walletBalance);
	}
}