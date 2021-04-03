package admin.models.factories;

import admin.models.LibItemData;
import common.factory.CleanData;
import common.factory.Factory;
import library.models.libraryitems.LibraryItem;
import library.models.contributors.Contributor;

import java.util.ArrayList;
import java.util.List;

public class LibraryItemFactory implements Factory<LibraryItem> {
    Factory<LibraryItem> bookFactory = new BookFactory();
    Factory<LibraryItem> audioBookFactory = new AudioBookFactory();
    Factory<LibraryItem> archiveFactory = new ArchiveFactory();
    Factory<LibraryItem> dvdFactory = new DvdFactory();

    @Override
    public LibraryItem create(CleanData cleanData) {
        LibraryItem newItem;
        LibItemData data = (LibItemData) cleanData;
        switch (data.type){
            case("Book") -> newItem = bookFactory.create(data);
            case("AudioBook") -> newItem = audioBookFactory.create(data);
            case("Archive") -> newItem =archiveFactory.create(data);
            case("DVD") -> newItem = dvdFactory.create(data);
            default -> newItem = bookFactory.create(data);
        }
        return newItem;
    }
}

