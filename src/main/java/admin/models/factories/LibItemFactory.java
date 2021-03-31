package admin.models.factories;

import admin.models.NewLibraryItemData;
import library.models.contributors.Contributor;
import library.models.libraryitems.LibraryItem;

import java.util.ArrayList;

public interface LibItemFactory {

    public LibraryItem create(NewLibraryItemData data, ArrayList<Contributor> contributors);
}
