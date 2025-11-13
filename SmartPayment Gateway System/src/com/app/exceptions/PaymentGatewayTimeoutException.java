package com.app.exceptions;

public class PaymentGatewayTimeoutException extends Exception{
	public PaymentGatewayTimeoutException(String msg) { 
		super(msg); 
	}
}
