package admin.models.factories;

import admin.models.NewLibraryItemData;
import library.models.libraryitems.Book;
import library.models.libraryitems.LibraryItem;
import library.models.contributors.Contributor;

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
