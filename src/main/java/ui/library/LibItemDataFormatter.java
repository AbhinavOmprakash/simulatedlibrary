package ui.library;

import backend.dataobjects.libraryitems.LibraryItem;
import backend.dataobjects.libraryitems.contributors.Contributor;

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
