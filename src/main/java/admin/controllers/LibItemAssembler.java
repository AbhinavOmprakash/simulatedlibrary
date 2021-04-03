package admin.controllers;

import admin.models.ContributorData;
import admin.models.LibItemData;
import admin.models.LibItemParts;
import common.factory.*;
import library.models.contributors.Contributor;
import library.models.libraryitems.LibraryItem;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LibItemAssembler extends Assembler<LibraryItem> {
    FactoryController<Contributor> contributorFactory;

    public LibItemAssembler(FactoryController<LibraryItem> mainFactory,
                            FactoryController<Contributor> contributorFactory) {
        super(mainFactory, new LibItemParts());
        this.contributorFactory = contributorFactory;
    }

    @Override
    protected void createParts(CleanData data) {
        ArrayList<CleanData> compatibleData = ((LibItemData) data).contributorData;
        List<Contributor> contributors = contributorFactory.createMany(compatibleData);
        System.out.println(contributors);
        ((LibItemParts) parts).setContributors((ArrayList<Contributor>) contributors);
    }

    //todo refactor. ugly method
    private ArrayList<CleanData> getContributorData(CleanData data) {
        ArrayList<CleanData> compatibleData = new ArrayList<>();
        LibItemData libItemData = (LibItemData) data;

        return compatibleData;
    }

    @Override
    protected LibraryItem assemble(Parts<LibraryItem> parts) {
        LibraryItem libraryItem = parts.getMainPart();
//        @SuppressWarnings("rawtypes, unchecked")
        ArrayList<Contributor> contributors = ((LibItemParts) parts).getContributors();
        libraryItem.setContributors(contributors);
        System.out.println(libraryItem.getContributors());
        return libraryItem;
    }
}
