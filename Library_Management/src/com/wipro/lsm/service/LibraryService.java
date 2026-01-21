package com.wipro.lsm.service;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import com.wipro.lsm.entity.Transaction;
import com.wipro.lsm.entity.Book;
import com.wipro.lsm.entity.Member;
import com.wipro.lsm.util.*;
public class LibraryService {

    private ArrayList<Book> books;
    private ArrayList<Member> members;
    private ArrayList<Transaction> transaction=new ArrayList<>();
    
    // Constructor (used in Main)
    public LibraryService(ArrayList<Book> books, ArrayList<Member> members) {
        this.books = books;
        this.members = members;
    }

    // Validate member
    public boolean validateMember(String memberId) throws InvalidMemberException {

        if (memberId == null || memberId.isEmpty()) {
            throw new InvalidMemberException();
        }

        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getMemberId().equals(memberId)) {
                return true;
            }
        }

        throw new InvalidMemberException();
    }

    // Check book availability
    public boolean checkBookAvailability(String bookId) throws BookNotAvailableException {

        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);

            if (b.getBookId().equals(bookId)) {
                if (b.getavailableCopies() > 0) {
                    return true;
                } else {
                    throw new BookNotAvailableException();
                }
            }
        }

        throw new BookNotAvailableException();
    }

    // Issue book
    public Transaction issueBook(String memberId, String bookId, int days) throws Exception {

        validateMember(memberId);
        checkBookAvailability(bookId);

        Book book = null;
        Member member = null;
        

        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getBookId().equals(bookId)) {
                book = books.get(i);
                break;
            }
        }

        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getMemberId().equals(memberId)) {
                member = members.get(i);
                break;
            }
        }

        book.setAvailableCopies(book.getavailableCopies() - 1);
        member.setBorrowedCount(member.getBorrowedCount() + 1);

         
        Transaction tx = new Transaction(memberId, bookId, bookId, null, null,9798);
        tx.setTransactionId("TXN" + memberId);
        tx.setMemberId(memberId);
        tx.setBookId(bookId);
        tx.setIssueDate(LocalDate.now());
        tx.setDueDate(LocalDate.now().plusDays(days));
        

        transaction.add(tx);
        
        return tx;
		
        
    }

    // Return book
    public double returnBook(String transactionId, LocalDate returnDate)
            throws TransactionException {

        Transaction tx = null;

        for (int i = 0; i < transaction.size(); i++) {
            if (transaction.get(i).gettransactionId().equals(transactionId)) {
                tx = transaction.get(i);
                break;
            }
        }

        if (tx == null || tx.getReturnDate() != null) {
            throw new TransactionException();
        }

        tx.setReturnDate(returnDate);

        Book book = null;
        Member member = null;

        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getBookId().equals(tx.getbookId())) {
                book = books.get(i);
                book.setAvailableCopies(book.getavailableCopies() + 1);
                break;
            }
        }

        for (int i = 0; i < members.size(); i++) {
            if (members.get(i).getMemberId().equals(tx.getmemberId())) {
                member = members.get(i);
                member.setBorrowedCount(member.getBorrowedCount() - 1);
                break;
            }
        }

        long daysLate = ChronoUnit.DAYS.between(tx.getDueDate(), returnDate);

        if (daysLate > 0) {
            return calculateFine(daysLate, member.getMembershipType());
        }

        return 0;
    }

    // Calculate fine
    private double calculateFine(long daysLate, String membershipType) {

        if ("REGULAR".equalsIgnoreCase(membershipType)) {
            return daysLate * 10;
        } else if ("PREMIUM".equalsIgnoreCase(membershipType)) {
            return daysLate * 5;
        }

        return 0;
    }
}
