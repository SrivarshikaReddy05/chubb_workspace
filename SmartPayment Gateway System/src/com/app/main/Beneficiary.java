package com.app.main;

public class Beneficiary {
	private String name;
	private String upiId;

	public Beneficiary(String name, String upiId) {
		this.name = name;
		this.upiId = upiId;
	}

	public String getName() {
		return name;
	}

	public String getUpiId() {
		return upiId;
	}
}