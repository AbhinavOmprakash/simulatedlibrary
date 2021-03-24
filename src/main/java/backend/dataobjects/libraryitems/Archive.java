package backend.dataobjects.libraryitems;

import backend.dataobjects.libraryitems.contributors.Contributor;

import javax.persistence.Entity;
import java.util.ArrayList;

@Entity
public class Archive extends LibraryItem{
    public Archive(){
        // for hibernate
    }

    public Archive(String title,
                   String subject,
                   int UPC,
                   ArrayList<Contributor> contributors) {
        super(title, subject, UPC, contributors, false, 0, "Archive");

    }
}
