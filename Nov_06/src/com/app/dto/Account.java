package com.app.dto;
import java.util.*;
public record Account(String name,String accNo, Double bal) {
	public int add(int a , int b) {
		int c = a+b;
		return c;
	}
}
