package com.app.main;
import java.util.*;

import com.app.packgs.AccNoComparator;
import com.app.packgs.BalComparator;


public class Operations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Operations obj = new Operations();
		
		obj.processSortedList();
		obj.sortedAccNo();
	}
	
	public void processSortedList() {
		Accounts currAcc = null;
		
		BalComparator comp = new BalComparator();
		List<Accounts> accList = new ArrayList<Accounts>();
		Accounts c1 = new Accounts("Rohan","987654321012","TXN20251030A","India","HDFC0001456",87500.75);

		Accounts c2 = new Accounts("Virat","987654321013","TXN20251030B","USA","HDFC0001458",1000000);
		
		Accounts c3 = new Accounts("Sita","987654321020","TXN20251030C","China","HDFC0001460",50000.75);
		
		Accounts c4 = new Accounts("Moksha","987654321050","TXN20251030A","India","HDFC0001456",999999.75);

		accList.add(c2);
		accList.add(c1);
		accList.add(c3);
		accList.add(c4);
		
		Collections.sort(accList, comp);
		Iterator<Accounts> itr = accList.iterator();

		while (itr.hasNext()) {
			currAcc = itr.next();
			String name = currAcc.getName();
			System.out.println(name);
			System.out.println("Account balance "+currAcc.getBalance());
			
		}


	}
	
	
	public void sortedAccNo() {
		Accounts currAcc = null;
		
		AccNoComparator comp = new AccNoComparator();
		List<Accounts> accList = new ArrayList<Accounts>();
		Accounts c1 = new Accounts("Rohan","987654321012","TXN20251030A","India","HDFC0001456",87500.75);

		Accounts c2 = new Accounts("Virat","987654321013","TXN20251030B","USA","HDFC0001458",1000000);
		
		Accounts c3 = new Accounts("Sita","987654321020","TXN20251030C","China","HDFC0001460",50000.75);
		
		Accounts c4 = new Accounts("Moksha","987654321050","TXN20251030A","India","HDFC0001456",999999.75);

		accList.add(c2);
		accList.add(c1);
		accList.add(c3);
		accList.add(c4);
		
		Collections.sort(accList, comp);
		Iterator<Accounts> itr = accList.iterator();

		while (itr.hasNext()) {
			currAcc = itr.next();
			String name = currAcc.getName();
			System.out.println(name);
			System.out.println("Account Number"+currAcc.getAccno());
			
		}

		

	}

}
