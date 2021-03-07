package libraryitems;

import libraryitems.contributors.Contributor;

import java.util.ArrayList;

public abstract class LibraryItem {
    protected String title;
    protected String subject;
    protected int UPC;
    protected ArrayList<Contributor> contributors;
    protected boolean isBorrowable;
    protected boolean isCheckedOut;


    public LibraryItem(String title,
                       String subject,
                       int UPC,
                       ArrayList<Contributor> contributors,
                       boolean isBorrowable) {
        this.title = title;
        this.subject = subject;
        this.UPC = UPC;
        this.contributors = contributors;
        this.isBorrowable = isBorrowable;
        this.isCheckedOut = false;
    }

    public LibraryItem borrowItem()throws UnsupportedOperationException{
        if(isBorrowable && !isCheckedOut) {
            checkOut();
            return this;
        } else if(!isCheckedOut) {
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

    public ArrayList<Contributor> getContributors() {
        return contributors;
    }

    public void setContributors(ArrayList<Contributor> contributors) {
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


}
