package backend.libraryitems;

import backend.libraryitems.contributors.Contributor;

import javax.persistence.Entity;
import java.util.ArrayList;

@Entity
public class AudioBook extends LibraryItem{


    private static int defaultBorrowPeriod=30;

    int ISBN;

    public AudioBook(){
        // for hibernate
    }

    public AudioBook(String title, String subject, int UPC, ArrayList<Contributor> contributors, boolean isBorrowable, int ISBN) {
        this(title, subject, UPC, contributors, isBorrowable, defaultBorrowPeriod, ISBN);
    }
    public AudioBook(String title,
                String subject,
                int UPC,
                ArrayList<Contributor> contributors,
                boolean isBorrowable, int borrowPeriod,
                int ISBN) {
        super(title, subject, UPC, contributors, isBorrowable, borrowPeriod);
        this.ISBN = ISBN;
    }
}
