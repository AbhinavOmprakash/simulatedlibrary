package library;

import library.membershiplevels.MembershipLevel;
import libraryitems.LibraryItem;

import java.util.ArrayList;

public class User {

    final int ID;

    MembershipLevel membershipLevel;

    protected ArrayList<LibraryItem> borrowedItems = new ArrayList<>();

    double PenaltyDue;

    public User(int ID, MembershipLevel memberShipLevel, double penaltyDue) {
        this.ID = ID;
        this.membershipLevel = memberShipLevel;
        PenaltyDue = penaltyDue;
    }

    public Double getOverdueFeesPerDay(){
        return MembershipLevel.getOverdueFeesPerDay();
    }


    public int getID() {
        return ID;
    }

    public double getPenaltyDue() {
        return PenaltyDue;
    }

    public MembershipLevel getMembershipLevel() {
        return membershipLevel;
    }

    public void setMembershipLevel(MembershipLevel membershipLevel) {
        this.membershipLevel = membershipLevel;
    }

    public void setPenaltyDue(double penaltyDue) {
        PenaltyDue = penaltyDue;
    }
    public double getDiscounts(){
        return MembershipLevel.getDiscounts();
        }
}
