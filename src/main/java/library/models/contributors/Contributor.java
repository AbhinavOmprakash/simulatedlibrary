package library.models.contributors;

import common.models.Searchable;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Contributor implements Searchable {
    private String name;
    private String contributorType;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    private int id;

    public Contributor(){
        // for hibernate
    }

    public Contributor(String name, String ContributorType) {
        this.name = name;
        this.contributorType = ContributorType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Contributor)) return false;
        Contributor that = (Contributor) o;
        return getName().equals(that.getName()) && getContributorType().equals(that.getContributorType());
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContributorType() {
        return contributorType;
    }

    public void setContributorType(String contributorType) {
        this.contributorType = contributorType;
    }

    public String getTableName() {
        return "Contributor";
    }

    @Override
    public String getSearchableAttribute() {
        return "name";
    }
}
