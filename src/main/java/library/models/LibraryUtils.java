package library.models;

import common.models.DataManager;
import common.models.Member;
import library.models.contributors.Contributor;
import library.models.libraryitems.LibraryItem;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// todo split class?
public class LibraryUtils {
    private final DataManager borrowedItemsRecord;

    public LibraryUtils(DataManager borrowedItemsRecord) {
        this.borrowedItemsRecord = borrowedItemsRecord;
    }

    public boolean isNotBorrowed(LibraryItem item){
        Object results = borrowedItemsRecord.search(item.getId()); //todo - chained function call, knows too much
        return (results==null);
    }

    public boolean isBorrowed(LibraryItem item){
        Object results = borrowedItemsRecord.search(item.getId()); //todo - chained function call, knows too much
        return (results!=null);
    }

    public boolean isOverdue(LibraryItem item){
        LocalDateTime returnDeadline = getReturnDeadline(item);
        LocalDateTime today = LocalDateTime.now();
        return (today.isAfter(returnDeadline));
    }

    private LocalDateTime getReturnDeadline(LibraryItem item) {
        LocalDateTime borrowedOn = getBorrowedOnDate(item);
        int borrowPeriod = item.getBorrowPeriodInDays();
        return borrowedOn.plusDays(borrowPeriod);
    }

    private LocalDateTime getBorrowedOnDate(LibraryItem item) {
        BorrowedItem borrowedItem = getRecordFor(item);
        return borrowedItem.getBorrowedOn();
    }

    private BorrowedItem getRecordFor(LibraryItem item) {
        return (BorrowedItem) borrowedItemsRecord.search(item.getId());
    }

    public int getOverdueDays(LibraryItem item){
        LocalDateTime returnDeadline = getReturnDeadline(item);
        LocalDateTime today = LocalDateTime.now();
        Period period = Period.between(returnDeadline.toLocalDate(), today.toLocalDate());
        return period.getDays();
    }

    public static String getFormattedTitle(LibraryItem item) {
        return item.getTitle();
    }

    public static String getFormattedContributors(LibraryItem item) {
        return constructContributorString(item.getContributors());
    }

    private static String constructContributorString(List<Contributor> contributors){
        Map<String, String> typeWithNames = getContributorTypeWithNames(contributors);
        return parseContributorWithNames(typeWithNames).toString();
    }

    private static Map<String, String> getContributorTypeWithNames(List<Contributor> contributors){
        Map<String, String> typeWithNames = new HashMap<>();
        for (Contributor contributor: contributors){
            typeWithNames.put(contributor.getName(), contributor.getContributorType());
        }
        return typeWithNames;
    }

    private static StringBuffer parseContributorWithNames(Map<String, String> typeWithNames ){

        StringBuffer contributorString = new StringBuffer("By - ");
        String spacer = "     "; //length of the By - string. required for proper alignment
        for(Map.Entry<String, String> entry: typeWithNames.entrySet()){
            contributorString.append(entry.getValue()+" : ");
            contributorString.append(entry.getKey()+"\n");
            contributorString.append(spacer);
        }
        return contributorString;
    }

    public static String constructCheckoutString(Boolean checkedOutStatus){
        StringBuilder str = new StringBuilder("Checked out - ");
        if (checkedOutStatus){
            str.append("Yes");
        } else {
            str.append("No");
        }
        return str.toString();
    }
}
