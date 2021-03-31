package admin.models.factories;

import admin.models.NewLibraryItemData;
import library.models.libraryitems.Archive;
import library.models.libraryitems.LibraryItem;
import library.models.contributors.Contributor;

import java.util.ArrayList;

public class ArchiveFactory implements LibItemFactory{

    @Override
    public LibraryItem create(NewLibraryItemData data, ArrayList<Contributor> contributors){
        return new Archive(data.title,
                data.subject,
                data.UPC,
                contributors);
    }
}
