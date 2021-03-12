package libraryitems;

import libraryitems.contributors.Contributor;

import javax.persistence.Entity;
import java.util.ArrayList;

@Entity
public class Archives extends LibraryItem{
    public Archives(){
        // for hibernate
    }

    public Archives(String title,
                     String subject,
                     int UPC,
                    ArrayList<Contributor> contributors) {
        super(title, subject, UPC, contributors, false, 0);

    }
}
