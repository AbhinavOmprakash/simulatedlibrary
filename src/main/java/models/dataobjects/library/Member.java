package models.dataobjects.library;

import models.DataObservable;
import models.dataobjects.library.membershiplevels.MembershipLevel;
import models.dataobjects.libraryitems.LibraryItem;
import views.DataObserver;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member extends User implements DataObservable {
    @Embedded
    private MembershipLevel membershipLevel;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<LibraryItem> borrowedItems = new ArrayList<>();

    @Transient
    ArrayList<DataObserver> observers = new ArrayList<>();

    public Member(){
        // for hibernate
    }

    public Member(String firstName, String lastName, String userName, MembershipLevel membershipLevel) {
        super(firstName, lastName, userName);
        this.membershipLevel = membershipLevel;
    }

    public void addBorrowedItem(LibraryItem item){
        borrowedItems.add(item);
        notifyObservers();
    }

    public void returnBorrowedItem(LibraryItem item){
        borrowedItems.remove(item);
        notifyObservers();
    }

    public void registerListener(DataObserver listener){
        observers.add(listener);

    }
    public void removeListener(DataObserver listener){
        observers.remove(listener);

    }
    public void notifyObservers(){
        for(DataObserver o:observers){
            o.performAction();
        }

    }

    public MembershipLevel getMembershipLevel() {
        return membershipLevel;
    }

    public void setMembershipLevel(MembershipLevel membershipLevel) {
        this.membershipLevel = membershipLevel;
    }

    public List<LibraryItem> getBorrowedItems() {
        return borrowedItems;
    }

    public void setBorrowedItems(List<LibraryItem> borrowedItems) {
        this.borrowedItems = borrowedItems;
    }
}
