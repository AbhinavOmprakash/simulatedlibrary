package library;

import library.membershiplevels.MembershipLevel;
import libraryitems.LibraryItem;
import org.hibernate.annotations.Columns;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table( name = "User")
public class User {
    String fullName;
    protected int ID;
    @Embedded
    MembershipLevel membershipLevel;
    protected ArrayList<LibraryItem> borrowedItems = new ArrayList<>();
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

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
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

    public ArrayList<LibraryItem> getBorrowedItems() {
        return borrowedItems;
    }

    public void setBorrowedItems(ArrayList<LibraryItem> borrowedItems) {
        this.borrowedItems = borrowedItems;
    }

    public double getPenaltyDue() {
        return PenaltyDue;
    }

    public void setPenaltyDue(double penaltyDue) {
        PenaltyDue = penaltyDue;
    }


}