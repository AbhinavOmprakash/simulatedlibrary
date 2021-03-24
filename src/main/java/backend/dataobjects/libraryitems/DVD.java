package backend.dataobjects.libraryitems;

import backend.dataobjects.libraryitems.contributors.Contributor;

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
               int UPC, ArrayList<Contributor> contributors,
               boolean isBorrowable) {
       this(title, subject, UPC, contributors, isBorrowable, defaultBorrowPeriod);
    }

    public DVD(String title, String subject,
               int UPC, ArrayList<Contributor> contributors,
               boolean isBorrowable, int borrowPeriodInDays) {
        super(title, subject, UPC, contributors, isBorrowable, borrowPeriodInDays, "DVD");
    }

    public static void setDefaultBorrowPeriod(int defaultBorrowPeriod) {
        DVD.defaultBorrowPeriod = defaultBorrowPeriod;
    }
}
