package backend.library;

import backend.library.membershiplevels.MembershipLevel;
import backend.library.records.BorrowedItems;
import backend.libraryitems.LibraryItem;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

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

    public User() {
        // for hibernate
    }

    public User(String name, MembershipLevel memberShipLevel) {
        this.name = name;
        this.membershipLevel = memberShipLevel;
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

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

}