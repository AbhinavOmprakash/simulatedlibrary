package library.models.libraryitems;

import library.models.contributors.Contributor;

import javax.persistence.Entity;
import java.util.ArrayList;

@Entity
public class Book extends LibraryItem{
    private static int defaultBorrowPeriod=30;
    int ISBN;
    public Book(){
        // for hibernate
    }

    // construct with default borrowPeriod
    public Book(String title,
                String subject,
                int UPC,
                boolean isBorrowable, int ISBN) {
        this(title, subject, UPC, isBorrowable, defaultBorrowPeriod, ISBN);
    }

    public Book(String title, String subject,
                int UPC, boolean isBorrowable, int borrowPeriodInDays, int ISBN) {
        super(title, subject, UPC, isBorrowable, borrowPeriodInDays, "Book");
        this.ISBN = ISBN;
    }

    public static void setDefaulBorrowPeriod(int defaultBorrowPeriod) {
        Book.defaultBorrowPeriod = defaultBorrowPeriod;
    }



}
