package admin.models.factories;

import admin.models.NewLibraryItemData;
import common.models.DataManager;
import library.models.libraryitems.LibraryItem;
import library.models.contributors.Contributor;

import java.util.ArrayList;

public class LibraryItemFactory implements LibItemFactory {
    LibItemFactory bookFactory = new BookFactory();
    LibItemFactory audioBookFactory = new AudioBookFactory();
    LibItemFactory archiveFactory = new ArchiveFactory();
    LibItemFactory dvdFactory = new DvdFactory();

    @Override
    public LibraryItem create(NewLibraryItemData data, ArrayList<Contributor> contributors) {
        LibraryItem newItem;
        switch (data.type){
            case("Book") -> newItem = bookFactory.create(data, contributors);
            case("AudioBook") -> newItem = audioBookFactory.create(data, contributors);
            case("Archive") -> newItem =archiveFactory.create(data, contributors);
            case("DVD") -> newItem = dvdFactory.create(data, contributors);
            default -> newItem = bookFactory.create(data, contributors);
        }
        return newItem;
    }
}

