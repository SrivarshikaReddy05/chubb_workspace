package com.app.main;

import java.util.*;
import com.app.exceptions.*;


import com.app.Payments.*;

public class SmartPay {
	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		Beneficiary[] beneficiaries = { 
				new Beneficiary("Arjun", "arjun@upi"), 
				new Beneficiary("Priya", "priya@upi"),
				new Beneficiary("Ravi", "ravi@upi") 
			};
		try {
			System.out.print("Enter beneficiary name: ");
			String beneName = sc.next();

			Beneficiary bene = findBeneficiary(beneficiaries, beneName);
			System.out.print("Enter amount to pay: ₹");
			double amount = sc.nextDouble();

			System.out.println("Select Payment Mode: 1-UPI, 2-Wallet, 3-CreditCard, 4-NetBanking");
			int mode = sc.nextInt();

			Payment payment = null;

			switch (mode) {
			case 1:
				payment = new UPIPayment(amount, bene.getName(), true);
				break;
			case 2:
				payment = new WalletPayment(amount, bene.getName(), 100);
				break;
			case 3:
				payment = new CreditCardPayment(amount, bene.getName(), true);
				break;
			case 4:
				payment = new NetBankingPayment(amount, bene.getName(), true);
				break;
			default:
				System.out.println("Invalid mode.");
				return;
			}

			payment.processPayment();
		} catch (InvalidAmountException e) {
			System.out.println("Invalid Amount: " + e.getMessage());
		} catch (InsufficientBalanceException e) {
			System.out.println("Insufficient Balance: " + e.getMessage());
		} catch (InvalidCredentialsException e) {
			System.out.println("Invalid Credentials. Please retry.");
		} catch (BeneNotFoundException e) {
			System.out.println("Beneficiary not found. Add a valid beneficiary.");
		} catch (TransactionFailedException e) {
			System.out.println("Transaction failed: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error: " + e.getMessage());
		}
	}

	private static Beneficiary findBeneficiary(Beneficiary[] list, String name) throws BeneNotFoundException {
		for (Beneficiary b : list) {
			if (b.getName().equalsIgnoreCase(name)) {
				return b;
			}
		}
		throw new BeneNotFoundException("Beneficiary not found: " + name);
	}
}