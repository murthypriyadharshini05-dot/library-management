package com.wipro.lsm.entity;

public class Member {
 private String memberId;
 private String name;
 private String membershipType;
 private int borrowedCount;
     public Member(String memberId,String name,String membershipType,int borrowedCount) {
    	 this.memberId=memberId;
    	 this.name=name;
    	 this.membershipType=membershipType;
    	 this.borrowedCount=borrowedCount;
     }
     public String getMemberId() {
         return memberId;
     }

     public String getName() {
         return name;
     }

     public String getMembershipType() {
         return membershipType;
     }

     public int getBorrowedCount() {
         return borrowedCount;
     }

     // Setters
     public void setMemberId(String memberId) {
         this.memberId = memberId;
     }

     public void setName(String name) {
         this.name = name;
     }

     public void setMembershipType(String membershipType) {
         this.membershipType = membershipType;
     }

     public void setBorrowedCount(int borrowedCount) {
         this.borrowedCount = borrowedCount;
     }
 }

