package admin.models.factories;

import admin.models.ContributorData;
import common.factory.CleanData;
import common.factory.Factory;
import library.models.contributors.*;

public class ContributorFactory implements Factory<Contributor> {
    @Override
    public Contributor create(CleanData cleanData) {
        Contributor newContributor;
        ContributorData data = (ContributorData) cleanData;
        String type = data.type;
        String name = data.name;

        switch (type) {
            case "Author" -> newContributor = new Author(name);
            case "Actor" -> newContributor = new Actor(name);
            case "Director" -> newContributor = new Director(name);
            case "Singer" -> newContributor = new Singer(name);
            case "ScreenWriter" -> newContributor = new ScreenWriter(name);
            case "Poet" -> newContributor = new Poet(name);
            default -> newContributor = new Author(name);
        }
        System.out.println("new contributor"+newContributor.getName());
        return newContributor;

    }
}