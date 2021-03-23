package backend.library;

import backend.library.membershiplevels.MembershipLevel;
import backend.libraryitems.LibraryItem;
import net.bytebuddy.build.Plugin;
import org.hibernate.annotations.Fetch;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member extends User{
    @Embedded
    private MembershipLevel membershipLevel;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<LibraryItem> borrowedItems = new ArrayList<>();

    public Member(){
        // for hibernate
    }

    public Member(String firstName, String lastName, String userName, MembershipLevel membershipLevel) {
        super(firstName, lastName, userName);
        this.membershipLevel = membershipLevel;
    }

    public void addBorrowedItem(LibraryItem item){
        borrowedItems.add(item);
    }

    public void returnBorrowedItem(LibraryItem item){
        borrowedItems.remove(item);
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