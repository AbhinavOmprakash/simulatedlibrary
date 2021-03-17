package backend.libraryitems.contributors;


import javax.persistence.Entity;

@Entity
public class Actor extends Contributor{
    public Actor(){}

    public Actor(String name) {
        super(name, "Actor");
    }
}
