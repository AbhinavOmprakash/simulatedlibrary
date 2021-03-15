package libraryitems.contributors;

import javax.persistence.Entity;

@Entity
public class Director extends Contributor{
    public Director(){}

    public Director(String name) {
        super(name);
    }
}
