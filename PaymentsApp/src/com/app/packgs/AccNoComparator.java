package com.app.packgs;

import java.util.Comparator;

import com.app.main.Accounts;

public class AccNoComparator implements Comparator<Accounts> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public int compare(Accounts o1, Accounts o2) {
		// TODO Auto-generated method stub
		Accounts acc1 = (Accounts)o1;
		Accounts acc2 = (Accounts)o2;
		if(acc1.getBalance() < acc2.getBalance()) return -1;
		else if (acc1.getBalance() > acc2.getBalance()) return 1;
		else return 0;
		
	}

}
