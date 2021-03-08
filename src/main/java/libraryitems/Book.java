package libraryitems;

import libraryitems.contributors.Contributor;

import java.util.ArrayList;

public class Book extends LibraryItem{

    public Book(String title,
                String subject,
                int UPC,
                ArrayList<Contributor> contributors,
                boolean isBorrowable) {

        super(title, subject, UPC, contributors, isBorrowable);
    }


}
