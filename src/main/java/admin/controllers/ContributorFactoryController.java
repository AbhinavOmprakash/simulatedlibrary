package admin.controllers;

import admin.models.ContributorData;
import common.factory.CleanData;
import common.factory.Factory;
import common.factory.FactoryController;
import common.models.DataManager;
import library.models.contributors.Contributor;

import java.util.ArrayList;
import java.util.List;

//todo find better name
public class ContributorFactoryController extends FactoryController<Contributor> {

    public ContributorFactoryController(DataManager dataManager, Factory<Contributor> factory) {
        super(dataManager, factory);
    }

    @Override
    public ArrayList<Contributor> createMany(List<CleanData> cleanData){
        ArrayList<Contributor> contributors = new ArrayList<>();
        for(CleanData data: cleanData){
            contributors.add(createContributor(data));
        }
        return contributors;
    }

    private Contributor createContributor(CleanData cleanData) {
        if(contributorExists(cleanData)){
            return getContributor(cleanData);
        } else {
            return super.create(cleanData);
        }
    }

    private Contributor getContributor(CleanData cleanData){
        ContributorData data = (ContributorData) cleanData;
        return (Contributor) dataManager.search(data.name);
    }

    private boolean contributorExists(CleanData cleanData) {
        ContributorData data = (ContributorData) cleanData;
        Contributor contributor = getContributor(cleanData);
        return (contributor != null &&
                contributor.getName().equals(data.name) &&
                contributor.getContributorType().equals(data.type));
    }
}
