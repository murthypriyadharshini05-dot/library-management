package com.wipro.lsm.main;

import java.util.ArrayList;

import com.wipro.lsm.entity.Book;
import com.wipro.lsm.entity.Member;
import com.wipro.lsm.entity.Transaction;
import com.wipro.lsm.service.LibraryService;
;

public class Main {

    public static void main(String[] args) {

        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("B001", "The Alchemist", "Paulo Coelho", 3, 3));
        books.add(new Book("B002", "Clean Code", "Robert Martin", 2, 0));

        ArrayList<Member> members = new ArrayList<>();
        members.add(new Member("M001", "John Carter", "REGULAR", 0));
        members.add(new Member("M002", "Alice Johnson", "PREMIUM", 0));

        LibraryService service = new LibraryService(books, members);

        try {
            // Validate member and check book
            service.validateMember("M001");
            service.checkBookAvailability("B001");

            // Issue book
            Transaction tx = service.issueBook("M001", "B001", 14);
            System.out.println("Issued Successfully!");
            System.out.println("Transaction ID: " + tx.gettransactionId());

            // Late return (5 days late)
            double fine = service.returnBook(
                    tx.gettransactionId(),
                    java.time.LocalDate.now().plusDays(19)
            );

            System.out.println("Fine Amount on Return: Rs. " + fine);

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}
