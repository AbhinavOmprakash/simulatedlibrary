package libraryitems.contributors;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Entity
public class Author extends Contributor{
    public Author(){
        // for hibernate
    }

    public Author(String name) {
        super(name);
    }
}
