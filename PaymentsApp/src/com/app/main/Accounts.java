package com.app.main;

public class Accounts {
	
	public Accounts(String name,String accno,String transcode , String country , String ifscode , double balance) {
		this.name = name;
		this.accno = accno;
		this.transcode = transcode;
		this.country = country;
		this.ifscode = ifscode;
		this.balance = balance;
	}
	
	String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccno() {
		return accno;
	}

	public void setAccno(String accno) {
		this.accno = accno;
	}

	public String getTranscode() {
		return transcode;
	}

	public void setTranscode(String transcode) {
		this.transcode = transcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getIfscode() {
		return ifscode;
	}

	public void setIfscode(String ifscode) {
		this.ifscode = ifscode;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	String accno;String transcode ; String country ; String ifscode ; double balance;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
