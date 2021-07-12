package library.models.libraryitems;

import common.models.Searchable;
import library.models.contributors.Contributor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

@Entity
@Table( name = "LibraryItem")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class LibraryItem implements Searchable {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    protected long id;
    protected String title;
    protected String subject;
    protected int UPC;

    @ManyToMany(fetch = FetchType.EAGER)
    protected List<Contributor> contributors;
    protected int borrowPeriodInDays;
    protected boolean isBorrowable;

    private String searchableString;

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
        this.type = type;
    }

    public LibraryItem(String title, String subject, int UPC,
                       boolean isBorrowable,
                       int borrowPeriodInDays, String type) {
        this.title = title;
        this.subject = subject;
        this.UPC = UPC;
        this.isBorrowable = isBorrowable;
        this.borrowPeriodInDays = borrowPeriodInDays;
        this.type = type;
    }

    private String[] constructSearchable(){
        searchableString = String.format("%s %s %s", title,
                subject,
                contributors.toString()).toLowerCase();
        searchableString = searchableString.replaceAll("[^a-z ]","");
        return searchableString.split(" ");
    }

    public String[] getSearchableString() {
        return constructSearchable();
    }

    @Override
    public String getSearchableAttribute() {
        return "title";
    }
    //getters and setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public int getBorrowPeriodInDays() {
        return borrowPeriodInDays;
    }

    public void setBorrowPeriodInDays(int borrowPeriodInDays) {
        this.borrowPeriodInDays = borrowPeriodInDays;
    }

    public boolean isBorrowable() {
        return isBorrowable;
    }

    public void setBorrowable(boolean borrowable) {
        isBorrowable = borrowable;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LibraryItem)) return false;
        LibraryItem that = (LibraryItem) o;
        return getId() == that.getId();
    }

    public String getTableName() {
        return "LibraryItem";
    }

}
