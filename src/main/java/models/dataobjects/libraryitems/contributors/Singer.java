package models.dataobjects.libraryitems.contributors;
import javax.persistence.Entity;

@Entity
public class Singer extends Contributor{
    public Singer(){}
    public Singer(String name) {
        super(name, "Singer");
    }
}
