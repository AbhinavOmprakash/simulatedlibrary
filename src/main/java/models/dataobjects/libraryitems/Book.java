package models.dataobjects.libraryitems;

import models.dataobjects.libraryitems.contributors.Contributor;

import javax.persistence.Entity;
import java.util.ArrayList;

@Entity
public class Book extends LibraryItem{

    private static int defaultBorrowPeriod=30;

    int ISBN;

    public Book(){
        // for hibernate
    }

    public Book(String title,
                String subject,
                int UPC,
                ArrayList<Contributor> contributors,
                boolean isBorrowable, int ISBN) {
        this(title, subject, UPC, contributors, isBorrowable, defaultBorrowPeriod, ISBN);
    }

    public Book(String title, String subject,
                int UPC, ArrayList<Contributor> contributors,
                boolean isBorrowable, int borrowPeriodInDays, int ISBN) {
        super(title, subject, UPC, contributors, isBorrowable, borrowPeriodInDays, "Book");
        this.ISBN = ISBN;
    }

    public static void setDefaultBorrowPeriod(int defaultBorrowPeriod) {
        Book.defaultBorrowPeriod = defaultBorrowPeriod;
    }



}
