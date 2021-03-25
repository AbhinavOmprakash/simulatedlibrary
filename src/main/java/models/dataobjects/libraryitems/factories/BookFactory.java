package models.dataobjects.libraryitems.factories;

import models.dataobjects.libraryitems.Book;
import models.dataobjects.libraryitems.LibraryItem;
import models.dataobjects.libraryitems.contributors.Contributor;

import java.util.ArrayList;

public class BookFactory{
    public static LibraryItem createNew(NewLibraryItemData data, ArrayList<Contributor> contributors){
        return new Book(data.title,
                data.subject,
                data.UPC,
                contributors,
                data.isBorrowable,
                data.ISBN,
                data.borrowPeriodInDays);
    }
}
