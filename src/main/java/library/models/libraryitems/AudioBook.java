package library.models.libraryitems;

import library.models.contributors.Contributor;

import javax.persistence.Entity;
import java.util.ArrayList;

@Entity
public class AudioBook extends LibraryItem{
    private static int defaultBorrowPeriod=30;
    int ISBN;
    public AudioBook(){
        // for hibernate
    }

    public AudioBook(String title,
                     String subject,
                     int UPC,
                     boolean isBorrowable,
                     int ISBN) {
        this(title, subject, UPC, isBorrowable, defaultBorrowPeriod, ISBN);
    }

    public AudioBook(String title,
                String subject,
                int UPC,
                boolean isBorrowable, int borrowPeriod,
                int ISBN) {
        super(title, subject, UPC, isBorrowable, borrowPeriod, "Audio Book");
        this.ISBN = ISBN;
    }
}
