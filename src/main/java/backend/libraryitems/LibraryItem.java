package backend.libraryitems;

import backend.libraryitems.contributors.Contributor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Entity
@Table( name = "LibraryItem")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class LibraryItem{

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    protected long id;
    protected String title;
    protected String subject;
    protected int UPC;

    @ManyToMany(fetch = FetchType.EAGER)
    protected List<Contributor> contributors;
    protected int borrowPeriodInDays;
    protected boolean isBorrowable;
    protected boolean isCheckedOut;


    protected String type;

    public LibraryItem(){
        // for hibernate's use
    }

    public LibraryItem(String title, String subject, int UPC,
                       List<Contributor> contributors, boolean isBorrowable,
                       int borrowPeriodInDays, String type) {
        this.title = title;
        this.subject = subject;
        this.UPC = UPC;
        this.contributors = contributors;
        this.isBorrowable = isBorrowable;
        this.borrowPeriodInDays = borrowPeriodInDays;
        this.isCheckedOut = false;
        this.type = type;
    }

    public LibraryItem borrowItem()throws UnsupportedOperationException{
        if(isBorrowable && !isCheckedOut) {
            checkOut();
            return this;
        } else if(isCheckedOut) {
            throw new UnsupportedOperationException(
                    String.format("Sorry this %s is already checked Out",getClass()));
        } else if(!isBorrowable) {
            throw new UnsupportedOperationException(
                    String.format("Sorry this %s is not borrowable", getClass()));
        }
        return null;
    }

    public void returnItem(){
        checkIn();
    }

    public void checkOut(){
        isCheckedOut = true;
    }

    public void checkIn(){
        isCheckedOut = false;
    }

    //getters and setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getUPC() {
        return UPC;
    }

    public void setUPC(int UPC) {
        this.UPC = UPC;
    }

    public List<Contributor> getContributors() {
        return contributors;
    }

    public void setContributors(List<Contributor> contributors) {
        this.contributors = contributors;
    }

    public boolean isBorrowable() {
        return isBorrowable;
    }

    public void setBorrowable(boolean borrowable) {
        isBorrowable = borrowable;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }


    public Long getId(){
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getBorrowPeriodInDays() {
        return borrowPeriodInDays;
    }

    public void setBorrowPeriodInDays(int borrowPeriodInDays) {
        this.borrowPeriodInDays = borrowPeriodInDays;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }   public void setID(long id){
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String toString(){
        return title;
    }
}
