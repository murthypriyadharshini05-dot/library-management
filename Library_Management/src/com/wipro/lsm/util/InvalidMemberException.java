package com.wipro.lsm.util;

public class InvalidMemberException extends Exception {
	@Override
	public String toString() {
		return "InvalidMemberException: Doesnt exist in the registered list.";
	}
	

}
