package backend.library;

import backend.library.membershiplevels.MembershipLevel;
import backend.libraryitems.LibraryItem;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "User")
public class User {
    private String name;


    private String userName;
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    protected int ID;
    @Embedded
    MembershipLevel membershipLevel;

    public double PenaltyDue;

    public User() {
        // for hibernate
    }

    public User(String name, MembershipLevel memberShipLevel, double penaltyDue) {
        this.name = name;
        this.membershipLevel = memberShipLevel;
        PenaltyDue = penaltyDue;
    }

    @Override
    public boolean equals(Object o ){
        if (o == this){
            return true;
        }

        if (!(o instanceof User)){
            return false;
        }
        User givenUser = (User) o;

        return this.getUserName().equals(givenUser.getUserName());

    }

    public Double discountPercentForUser(){
        return membershipLevel.getDiscountPercentage();
    }

    public Double overdueFeesForUser(){
        return membershipLevel.getOverdueFeesPerDay();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public double getPenaltyDue() {
        return PenaltyDue;
    }

    public void setPenaltyDue(double penaltyDue) {
        PenaltyDue = penaltyDue;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}