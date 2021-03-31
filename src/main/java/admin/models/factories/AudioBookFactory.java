package admin.models.factories;

import admin.models.NewLibraryItemData;
import library.models.libraryitems.AudioBook;
import library.models.libraryitems.LibraryItem;
import library.models.contributors.Contributor;

import java.util.ArrayList;

public class AudioBookFactory implements LibItemFactory {
    @Override
    public LibraryItem create(NewLibraryItemData data, ArrayList<Contributor> contributors) {
        return new AudioBook(data.title,
                data.subject,
                data.UPC,
                contributors,
                data.isBorrowable,
                data.ISBN,
                data.borrowPeriodInDays);
    }
}
