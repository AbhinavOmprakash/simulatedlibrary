package libraryitems;

import libraryitems.contributors.Contributor;

import java.util.ArrayList;

public class DVD extends LibraryItem{

    public DVD(String title,
               String subject,
               int UPC, ArrayList<Contributor> contributors,
               boolean isBorrowable) {
        super(title, subject, UPC, contributors, isBorrowable);
    }
}
