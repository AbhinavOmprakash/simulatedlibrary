package models.dataobjects.libraryitems.factories;

import models.dataobjects.libraryitems.LibraryItem;
import models.dataobjects.libraryitems.contributors.Contributor;

import java.util.ArrayList;

public class LibraryItemFactory {
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
        return newItem;
    }
}
