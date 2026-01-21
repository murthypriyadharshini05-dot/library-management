package com.wipro.lsm.util;

public class BookNotAvailableException extends Exception{
	@Override
	public String toString() {
		return "BookNotAvailableException: Book Does not Exist or has zero available copies.";
	}
   
}
