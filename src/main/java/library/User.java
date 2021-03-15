package library;

import library.membershiplevels.MembershipLevel;
import libraryitems.LibraryItem;
import org.hibernate.annotations.Columns;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "User")
public class User {
    private String fullName;
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    protected int ID;
    @Embedded
    MembershipLevel membershipLevel;

    @ElementCollection
    private List<LibraryItem> borrowedItems = new ArrayList<>();
    public double PenaltyDue;

    public User() {
        // for hibernate
    }

    public User(String fullName, MembershipLevel memberShipLevel, double penaltyDue) {
        this.fullName = fullName;
        this.membershipLevel = memberShipLevel;
        PenaltyDue = penaltyDue;
    }

    public Double discountPercentForUser(){
        return membershipLevel.getDiscountPercentage();
    }

    public Double overdueFeesForUser(){
        return membershipLevel.getOverdueFeesPerDay();
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public MembershipLevel getMembershipLevel() {
        return membershipLevel;
    }

    public void setMembershipLevel(MembershipLevel membershipLevel) {
        this.membershipLevel = membershipLevel;
    }

    public void borrowItem(LibraryItem item){
        borrowedItems.add(item);
    }

    public List<LibraryItem> getBorrowedItems() {
        return  borrowedItems;
    }

    public void setBorrowedItems(List<LibraryItem> borrowedItems) {
        this.borrowedItems = borrowedItems;
    }

    public double getPenaltyDue() {
        return PenaltyDue;
    }

    public void setPenaltyDue(double penaltyDue) {
        PenaltyDue = penaltyDue;
    }


}