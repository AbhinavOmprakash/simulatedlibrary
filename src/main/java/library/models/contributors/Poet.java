package library.models.contributors;

import javax.persistence.Entity;

@Entity
public class Poet extends Contributor{
    public Poet(){}

    public Poet(String name) {
        super(name, "Poet");
    }
}
