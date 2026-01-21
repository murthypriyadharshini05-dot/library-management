package com.wipro.lsm.entity;

public class Book {
   private String bookId;
   private String title;
   private String author;
   private int totalCopies;
   private int availableCopies;
   
   public Book(String bookId,String title,String author,int totalCopies,int availableCopies){
	   this.bookId=bookId;
	   this.title=title;
	   this.author=author;
	   this.totalCopies=totalCopies;
	   this.availableCopies=availableCopies;
   }
   public String getBookId() {
	   return bookId;
   }
   public String gettitle() {
	   return title;
   }
   public String getauthor() {
	   return author;
   }
   public int gettotalCopies() {
	   return totalCopies;
   }
   public int getavailableCopies() {
	   return availableCopies;
   }
   public void setBookId(String bookId) {
	   this.bookId=bookId;
   }
   public void settitle(String title) {
	   this.title=title;
   }

   public void setAuthor(String author) {
       this.author = author;
   }

   public void setTotalCopies(int totalCopies) {
       this.totalCopies = totalCopies;
   }

   public void setAvailableCopies(int availableCopies) {
       this.availableCopies = availableCopies;
   }
}
