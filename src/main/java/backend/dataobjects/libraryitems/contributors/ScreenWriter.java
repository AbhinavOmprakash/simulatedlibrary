package backend.dataobjects.libraryitems.contributors;
import javax.persistence.Entity;

@Entity
public class ScreenWriter extends Contributor{
    public ScreenWriter(){}
    public ScreenWriter(String name) {
        super(name, "Screen writer");
    }
}
