package libraryitems;

import java.util.ArrayList;

public abstract class LibraryItem {
    private String title;
    private String subject;
    private int UPC;
    private ArrayList<Contributor> contributors;
    private boolean isBorrowable;
    private boolean isCheckedOut;


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

    public void checkOut(){
        isCheckedOut = true;
    }

    public void checkIn(){
        isCheckedOut = false;
    }


}
