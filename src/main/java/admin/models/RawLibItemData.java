package admin.models;

import common.factory.CleanData;
import common.factory.RawData;

import java.util.ArrayList;
import java.util.Map;

public class RawLibItemData implements RawData {
    private String title;
    private String subject;
    private Map<String,String> contributorsWithType;
    private String UPC;
    private String ISBN;
    private Object isBorrowable;
    private Object borrowPeriodInDays;
    private Object type;

    public RawLibItemData(String title, String subject,
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

    public CleanData getCompatibleData(){
        ArrayList<CleanData> contributorData = createContributorData();
        return new LibItemData(title,
                subject,
                contributorData,
                Integer.parseInt(UPC),
                Integer.parseInt(ISBN),
                getIsBorrowable(),
                Integer.parseInt(String.valueOf(borrowPeriodInDays)),
                (String) type);
    }

    private ArrayList<CleanData> createContributorData() {
        ArrayList<CleanData> contributorData = new ArrayList<>();
        for(Map.Entry<String, String> entry: contributorsWithType.entrySet()){
            ContributorData data = new ContributorData();
            data.type = entry.getKey() ;
            data.name = entry.getValue();
            contributorData.add(data);
        }
        return contributorData;
    }

    private boolean getIsBorrowable() {
        return (String.valueOf(isBorrowable)).equals("yes");
    }

}
