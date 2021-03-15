package libraryitems;

import libraryitems.contributors.Contributor;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
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
        super(title, subject, UPC, contributors, isBorrowable, borrowPeriodInDays);
        this.ISBN = ISBN;
    }

    public static void setDefaultBorrowPeriod(int defaultBorrowPeriod) {
        Book.defaultBorrowPeriod = defaultBorrowPeriod;
    }



}
