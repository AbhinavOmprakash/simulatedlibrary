package admin.models;

import common.factory.Parts;
import library.models.contributors.Contributor;
import library.models.libraryitems.LibraryItem;

import java.util.ArrayList;

public class LibItemParts extends Parts<LibraryItem> {
    ArrayList<Contributor> contributors;

    public ArrayList<Contributor> getContributors() {
        return contributors;
    }

    public void setContributors(ArrayList<Contributor> contributors) {
        this.contributors = contributors;
    }
}
