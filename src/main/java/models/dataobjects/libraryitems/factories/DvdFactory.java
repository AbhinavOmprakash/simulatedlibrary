package models.dataobjects.libraryitems.factories;

import models.dataobjects.libraryitems.DVD;
import models.dataobjects.libraryitems.LibraryItem;
import models.dataobjects.libraryitems.contributors.Contributor;

import java.util.ArrayList;

public class DvdFactory {
    public static LibraryItem createNew(NewLibraryItemData data, ArrayList<Contributor> contributors) {
        return new DVD(data.title,
                data.subject,
                data.UPC,
                contributors,
                data.isBorrowable,
                data.borrowPeriodInDays);
    }
}
