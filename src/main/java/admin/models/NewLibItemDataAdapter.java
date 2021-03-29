package admin.models;

import admin.views.NewLibraryItem;

import java.util.Map;

public class NewLibItemDataAdapter {
    private String title;
    private String subject;
    private Map<String,String> contributorsWithType;
    private String UPC;
    private String ISBN;
    private Object isBorrowable;
    private Object borrowPeriodInDays;
    private Object type;

    public NewLibItemDataAdapter(String title, String subject,
                                 Map<String, String> contributorsWithType, String UPC,
                                 String ISBN, Object isBorrowable,
                                 Object borrowPeriodInDays, Object type) {
        this.title = title;
        this.subject = subject;
        this.contributorsWithType = contributorsWithType;
        this.UPC = UPC;
        this.ISBN = ISBN;
        this.isBorrowable = isBorrowable;
        this.borrowPeriodInDays = borrowPeriodInDays;
        this.type = type;
    }

    public NewLibraryItemData getCompatibleData(){

        return new NewLibraryItemData(title,
                subject,
                contributorsWithType,
                Integer.parseInt(UPC),
                Integer.parseInt(ISBN),
                getIsBorrowable(),
                Integer.parseInt(String.valueOf(borrowPeriodInDays)),
                (String) type);
    }

    private boolean getIsBorrowable() {
        return (String.valueOf(isBorrowable)).equals("yes");
    }


}
