package admin.models;

import java.util.Map;

public class NewLibraryItemData {
    public String title;
    public String subject;
    public Map<String,String> contributorsWithType;
    public int UPC;
    public int ISBN;
    public boolean isBorrowable;
    public int borrowPeriodInDays;
    public String type;

    public NewLibraryItemData(String title, String subject,
                              Map<String, String> contributorsWithType, int UPC,
                              int ISBN, boolean isBorrowable,
                              int borrowPeriodInDays, String type) {
        this.title = title;
        this.subject = subject;
        this.contributorsWithType = contributorsWithType;
        this.UPC = UPC;
        this.ISBN = ISBN;
        this.isBorrowable = isBorrowable;
        this.borrowPeriodInDays = borrowPeriodInDays;
        this.type = type;
    }
}