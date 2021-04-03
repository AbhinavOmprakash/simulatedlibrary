package admin.models.factories;

import admin.models.LibItemData;
import common.factory.CleanData;
import common.factory.Factory;
import library.models.libraryitems.Archive;
import library.models.libraryitems.LibraryItem;
import library.models.contributors.Contributor;

import java.util.ArrayList;
import java.util.List;

public class ArchiveFactory implements Factory<LibraryItem> {
    @Override
    public LibraryItem create(CleanData cleanData) {
        LibItemData data = (LibItemData) cleanData;
        return new Archive(data.title,
                data.subject,
                data.UPC);
    }

}
