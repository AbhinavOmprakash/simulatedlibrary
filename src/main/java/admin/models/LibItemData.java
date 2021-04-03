package admin.models;

import common.factory.CleanData;

import java.util.ArrayList;
import java.util.Map;

public class LibItemData implements CleanData {
    public String title;
    public String subject;
    public ArrayList<CleanData> contributorData;
    public int UPC;
    public int ISBN;
    public boolean isBorrowable;
    public int borrowPeriodInDays;
    public String type;

    public LibItemData(String title,
                       String subject,
                       ArrayList<CleanData> contributorData,
                       int UPC,
                       int ISBN,
                       boolean isBorrowable,
                       int borrowPeriodInDays,
                       String type) {
        this.title = title;
        this.subject = subject;
        this.contributorData = contributorData;
        this.UPC = UPC;
        this.ISBN = ISBN;
        this.isBorrowable = isBorrowable;
        this.borrowPeriodInDays = borrowPeriodInDays;
        this.type = type;
    }
}