package admin.models.factories;

import common.models.DataManager;
import library.models.ContributorManager;
import library.models.contributors.*;

import java.util.ArrayList;
import java.util.Map;

//todo improve design. functions have bad side effects.
@SuppressWarnings({"unchecked","rawtypes"})
public class ContributorFactory {
    private static DataManager contributorData = new ContributorManager();
    private static ArrayList<Contributor> contributors = new ArrayList<>();

    public static ArrayList<Contributor> getContributors(Map<String, String> contributorWithType){
        contributors = new ArrayList<>();
        createContributors(contributorWithType);

        // contributors is populated in createContributors.
        // todo correct side effect
        return contributors;
    }

    private static void createContributors(Map<String, String> contributorWithType){
        for(Map.Entry<String, String> entry: contributorWithType.entrySet()){
            String name = entry.getKey();
            String type =  entry.getValue();
            if(!contributorExists(name, type)){
                Contributor c = createNew(name, type);
                contributorData.addItem(c);
                contributors.add(c);
            }
        }
    }

    private static boolean contributorExists(String name, String type){
        ArrayList results = contributorData.search(name);
        for (Object contributor: results){
            Contributor c = (Contributor) contributor;
            if(c.getName().equals(name) && c.getContributorType().equals(type)) {
                contributors.add(c);
                return true;
            }
        }
        return false;
    }

    private static Contributor createNew(String name, String type){
        Contributor newContributor;
        switch (type) {
            case "Author" -> newContributor = new Author(name);
            case "Actor" -> newContributor = new Actor(name);
            case "Director" -> newContributor = new Director(name);
            case "Singer" -> newContributor = new Singer(name);
            case "ScreenWriter" -> newContributor = new ScreenWriter(name);
            case "Poet" -> newContributor = new Poet(name);
            default ->  newContributor = new Author(name);
        }
        return newContributor;
    }
}
