package libraryitems;

import libraryitems.contributors.Contributor;

import java.util.ArrayList;

public class AudioBook extends LibraryItem{
    int ISBN;

    public AudioBook(String title,
                String subject,
                int UPC,
                ArrayList<Contributor> contributors,
                boolean isBorrowable,
                int ISBN) {
        super(title, subject, UPC, contributors, isBorrowable);

        this.ISBN = ISBN;
    }
}
