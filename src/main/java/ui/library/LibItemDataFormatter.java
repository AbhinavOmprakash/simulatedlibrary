package ui.library;

import backend.libraryitems.LibraryItem;
import backend.libraryitems.contributors.Contributor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LibItemDataFormatter {

    public static String getFormattedTitle(LibraryItem item) {
        return item.getTitle();
    }

    public static String getFormattedContributors(LibraryItem item) {
        return constructContributorString(item.getContributors());
    }

    private static String constructContributorString(List<Contributor> contributors){
        Map<String, String> typeWithNames = getContributorTypeWithNames(contributors);
        StringBuffer contributorsWithNames =parseContributorWithNames(typeWithNames);
        StringBuffer formattedString = contributorsWithNames.insert(0,"By - ");
        return formattedString.toString();
    }

    private static Map<String, String> getContributorTypeWithNames(List<Contributor> contributors){
        Map<String, String> typeWithNames = new HashMap<>();
        for (Contributor contributor: contributors){
            typeWithNames.put(contributor.getContributorType(), contributor.getName());
        }
        return typeWithNames;
    }

    private static StringBuffer parseContributorWithNames(Map<String, String> typeWithNames ){
        StringBuffer contributorString = new StringBuffer();
        for(Map.Entry<String, String> entry: typeWithNames.entrySet()){
            contributorString.append(entry.getKey()+" : ");
            contributorString.append(entry.getValue()+"\n");
        }
        return contributorString;
    }

    public static String getFormattedCheckedOutStatus(LibraryItem item) {
        return constructCheckoutString(item.isCheckedOut());
    }

    private static String constructCheckoutString(Boolean checkedOutStatus){
        StringBuilder str = new StringBuilder("Checked out - ");
        if (checkedOutStatus){
            str.append("Yes");
        } else {
            str.append("No");
        }
        return str.toString();

    }
}
