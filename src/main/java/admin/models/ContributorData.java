package admin.models;

import common.factory.CleanData;

public class ContributorData implements CleanData {
    public String name;
    public String type;

    public ContributorData() {
    }

    public ContributorData(String name, String type) {
        this.name = name;
        this.type = type;
    }
}
