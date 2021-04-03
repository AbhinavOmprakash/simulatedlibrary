package admin.models.factories;

import admin.models.LibItemData;
import common.factory.CleanData;
import common.factory.Factory;
import library.models.libraryitems.Book;
import library.models.libraryitems.LibraryItem;

public class BookFactory implements Factory<LibraryItem> {

    @Override
    public LibraryItem create(CleanData cleanData) {
        LibItemData data = (LibItemData) cleanData;
        return new Book(data.title,
                data.subject,
                data.UPC,
                data.isBorrowable,
                data.ISBN,
                data.borrowPeriodInDays);
    }

}
