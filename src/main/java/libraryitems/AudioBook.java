package libraryitems;

import libraryitems.contributors.Contributor;

import java.util.ArrayList;

public class AudioBook extends LibraryItem{

    private static int defaultBorrowPeriod=30;

    int ISBN;

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
