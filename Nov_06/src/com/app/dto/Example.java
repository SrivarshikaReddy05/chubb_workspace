package com.app.dto;

public class Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String msg = """
				bxdak
				snlcna
				""";
		System.out.println(msg);
		int b = getBal();
		System.out.print(b);
	}
	public static int getBal() {
		String name = "james";
		int bal = switch(name) {
		case "hi","eufhc" -> 10000;
		case "james"
 -> 10;
		default -> 20;
 };
		return bal;
	}
}
