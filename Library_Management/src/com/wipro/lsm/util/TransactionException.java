package com.wipro.lsm.util;

public class TransactionException extends Exception {
    @Override
    public String toString() {
    	return "TransactionException: Invalid transaction details,Dulpicate returns.";
    }
	
	
}
