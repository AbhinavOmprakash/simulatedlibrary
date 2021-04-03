package admin.models.factories;

import admin.models.LibItemData;
import common.factory.CleanData;
import common.factory.Factory;
import library.models.libraryitems.DVD;
import library.models.libraryitems.LibraryItem;

import java.util.List;

public class DvdFactory implements Factory<LibraryItem> {

    @Override
    public LibraryItem create(CleanData cleanData) {
        LibItemData data = (LibItemData) cleanData;
        return new DVD(data.title,
                data.subject,
                data.UPC,
                data.isBorrowable,
                data.borrowPeriodInDays);
    }

}
