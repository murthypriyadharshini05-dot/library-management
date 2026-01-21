package com.wipro.lsm.entity;
import java.time.LocalDate;

public class Transaction {
	private String transactionId;
	private String memberId;
	private String bookId;
	private LocalDate issueDate;
	private LocalDate dueDate;
	private LocalDate returnDate;
	private double fine;
public Transaction(String transactionId, String memberId, String bookId, LocalDate issueDate, LocalDate dueDate, double fine) {
	this.transactionId = transactionId;
	this.memberId = memberId;
	this.bookId = bookId;
	this.issueDate = issueDate;
	this.dueDate = dueDate;
	this.fine = fine;
}

public String gettransactionId() {
	return transactionId;
}
public String getmemberId() {
	return memberId;
}
public String getbookId() {
    return bookId;
}

public LocalDate getIssueDate() {
    return issueDate;
}

public LocalDate getDueDate() {
    return dueDate;
}

public LocalDate getReturnDate() {
    return returnDate;
}

public double getFine() {
    return fine;
}
public void setTransactionId(String transactionId) {
    this.transactionId = transactionId;
}

public void setMemberId(String memberId) {
    this.memberId = memberId;
}


public void setIssueDate(LocalDate issueDate) {
    this.issueDate = issueDate;
}
public void setDueDate(LocalDate dueDate) {
    this.dueDate = dueDate;
}

public void setReturnDate(LocalDate returnDate) {
    this.returnDate = returnDate;
}

public void setFine(double fine) {
    this.fine = fine;
}

public void setBookId(String bookId) {
	// TODO Auto-generated method stub
	this.bookId = bookId;
	
}
}
