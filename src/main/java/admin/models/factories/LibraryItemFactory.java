package admin.models.factories;

import admin.models.NewLibraryItemData;
import common.models.DataManager;
import library.models.LibraryItemManager;
import library.models.libraryitems.LibraryItem;
import library.models.contributors.Contributor;

import java.util.ArrayList;

@SuppressWarnings({"unchecked, rawtypes"})
public class LibraryItemFactory {
    private static DataManager libraryItems = new LibraryItemManager();

    public static LibraryItem createNewItem(NewLibraryItemData data){
        ArrayList<Contributor> contributors = ContributorFactory.getContributors(data.contributorsWithType);
        LibraryItem newItem;
        switch (data.type){
            case("Book") -> newItem = BookFactory.createNew(data, contributors);
            case("AudioBook") -> newItem = AudioBookFactory.createNew(data, contributors);
            case("Archive") -> newItem = ArchiveFactory.createNew(data, contributors);
            case("DVD") -> newItem = DvdFactory.createNew(data, contributors);
            default -> newItem = BookFactory.createNew(data, contributors);
        }
        libraryItems.addItem(newItem);
        return newItem;
    }
}
