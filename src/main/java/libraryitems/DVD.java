package libraryitems;

import libraryitems.contributors.Contributor;

import java.util.ArrayList;

public class DVD extends LibraryItem{

    private static int defaultBorrowPeriod=10;


    public DVD(String title,
               String subject,
               int UPC, ArrayList<Contributor> contributors,
               boolean isBorrowable) {
       this(title, subject, UPC, contributors, isBorrowable, defaultBorrowPeriod);
    }

    public DVD(String title, String subject,
               int UPC, ArrayList<Contributor> contributors,
               boolean isBorrowable, int borrowPeriodInDays) {
        super(title, subject, UPC, contributors, isBorrowable, borrowPeriodInDays);
    }

    public static void setDefaultBorrowPeriod(int defaultBorrowPeriod) {
        DVD.defaultBorrowPeriod = defaultBorrowPeriod;
    }
}
