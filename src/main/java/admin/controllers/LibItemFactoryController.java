package admin.controllers;

import admin.models.NewLibraryItemData;
import admin.models.factories.LibItemFactory;
import common.models.DataManager;
import library.models.contributors.Contributor;
import library.models.libraryitems.LibraryItem;

import java.util.ArrayList;

public class LibItemFactoryController {
    private DataManager libraryItems;
    private LibItemFactory factory;
    private ContributorFactoryController contributorFactory;

    public LibItemFactoryController(DataManager libraryItems, LibItemFactory libItemFactory,
                                    ContributorFactoryController contributorFactory) {
        this.libraryItems = libraryItems;
        this.factory = libItemFactory;
        this.contributorFactory = contributorFactory;
    }

    //todo find better name. has side effect
    public void createNewLibItem(NewLibraryItemData data){
        ArrayList<Contributor> contributors = getContributors(data);
        LibraryItem item = factory.create(data, contributors);
        saveItem(item);
    }

    //todo find better name. has side effect
    private ArrayList<Contributor> getContributors(NewLibraryItemData data) {
        contributorFactory.createNewContributors(data.contributorsWithType);
        return contributorFactory.getContributors(data.contributorsWithType);
    }

    private void saveItem(LibraryItem item){
        libraryItems.addItem(item);
    }
}
