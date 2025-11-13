package com.app.basic;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Author> author = new ArrayList<>();
		Book b = new Book( 1 , "Wings of fire" , author,"ABC",50,2000.0,EDITION.FIRST,new Date());
		System.out.println(b.getYop());
	}

}
