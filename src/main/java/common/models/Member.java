package common.models;

import library.models.libraryitems.LibraryItem;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member extends User {
    @Embedded
    private MembershipLevel membershipLevel;

    @ElementCollection(fetch = FetchType.EAGER)
    List<LibraryItem> borrowedItems = new ArrayList<>();

    public Member(){
        // for hibernate
    }

    public Member(String firstName, String lastName, String userName, MembershipLevel membershipLevel) {
        super(firstName, lastName, userName);
        this.membershipLevel = membershipLevel;
    }

    public Member(String firstName, String lastName, String userName) {
        super(firstName, lastName, userName);
    }

    public void borrowItem(LibraryItem item){
        borrowedItems.add(item);
    }

    public void returnItem(LibraryItem item){
        borrowedItems.remove(item);
    }

    public int totalBorrowedItems(){
        return borrowedItems.size();
    }

    public boolean hasBorrowed(LibraryItem item){
        return borrowedItems.contains(item);
    }

    public boolean hasBorrowedItems(){
        return !borrowedItems.isEmpty();
    }

    public int getBorrowLimit(){
        return membershipLevel.getBorrowLimit();
    }
    public Double getOverduePerDay(){
        return membershipLevel.getOverdueFeesPerDay();
    }

    public static String getAccessPrivilege(){
        return "member";
    }
    // getters and setters
    public MembershipLevel getMembershipLevel() {
        return membershipLevel;
    }

    public void setMembershipLevel(MembershipLevel membershipLevel) {
        this.membershipLevel = membershipLevel;
    }

    public List<LibraryItem> getBorrowedItems() {
        return borrowedItems;
    }

    public void setBorrowedItems(ArrayList<LibraryItem> borrowedItems) {
        this.borrowedItems = borrowedItems;
    }
}
