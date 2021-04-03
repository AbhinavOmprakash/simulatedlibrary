package library.models.libraryitems;

import library.models.contributors.Contributor;

import javax.persistence.Entity;
import java.util.ArrayList;

@Entity
public class DVD extends LibraryItem{
    private static int defaultBorrowPeriod=10;
    public DVD(){
        // for hibernate
    }

    public DVD(String title,
               String subject,
               int UPC,boolean isBorrowable) {
       this(title, subject, UPC, isBorrowable, defaultBorrowPeriod);
    }

    public DVD(String title, String subject,
               int UPC,boolean isBorrowable, int borrowPeriodInDays) {
        super(title, subject, UPC, isBorrowable, borrowPeriodInDays, "DVD");
    }

    public static void setDefaultBorrowPeriod(int defaultBorrowPeriod) {
        DVD.defaultBorrowPeriod = defaultBorrowPeriod;
    }
}
