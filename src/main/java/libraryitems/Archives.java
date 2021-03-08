package libraryitems;

import libraryitems.contributors.Contributor;

import java.util.ArrayList;

public class Archives extends LibraryItem{

    public Archives(String title,
                     String subject,
                     int UPC,
                    ArrayList<Contributor> contributors) {
        super(title, subject, UPC, contributors, false, 0);

    }
}
