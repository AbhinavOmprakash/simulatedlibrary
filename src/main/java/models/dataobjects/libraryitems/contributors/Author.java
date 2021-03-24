package models.dataobjects.libraryitems.contributors;

import javax.persistence.Entity;

@Entity
public class Author extends Contributor{
    public Author(){
        // for hibernate
    }

    public Author(String name) {
        super(name, "Author");
    }
}
