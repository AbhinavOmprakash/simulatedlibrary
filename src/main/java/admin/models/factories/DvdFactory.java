package admin.models.factories;

import admin.models.NewLibraryItemData;
import library.models.libraryitems.DVD;
import library.models.libraryitems.LibraryItem;
import library.models.contributors.Contributor;

import java.util.ArrayList;

public class DvdFactory implements LibItemFactory {

    @Override
    public LibraryItem create(NewLibraryItemData data, ArrayList<Contributor> contributors) {
        return new DVD(data.title,
                data.subject,
                data.UPC,
                 contributors,
                data.isBorrowable,
                data.borrowPeriodInDays);
    }
}
