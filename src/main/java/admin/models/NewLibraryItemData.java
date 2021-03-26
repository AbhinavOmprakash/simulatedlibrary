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

}