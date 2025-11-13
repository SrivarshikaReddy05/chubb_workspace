package com.app.exceptions;

public class TransactionFailedException extends Exception{
	public TransactionFailedException(String msg, Throwable cause) {
		super(msg, cause);
	}
}

