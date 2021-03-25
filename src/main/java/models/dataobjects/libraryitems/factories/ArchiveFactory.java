package models.dataobjects.libraryitems.factories;

import models.dataobjects.libraryitems.Archive;
import models.dataobjects.libraryitems.Book;
import models.dataobjects.libraryitems.LibraryItem;
import models.dataobjects.libraryitems.contributors.Contributor;

import java.util.ArrayList;

public class ArchiveFactory {

    public static LibraryItem createNew(NewLibraryItemData data, ArrayList<Contributor> contributors){
        return new Archive(data.title,
                data.subject,
                data.UPC,
                contributors);
    }
}
