package backend.library;

import backend.library.User;

import javax.persistence.Entity;

@Entity
public class Admin extends User {

    public Admin() {
        // for hibernate
    }

    public Admin(String firstName, String lastName, String userName) {
        super(firstName, lastName, userName);
    }
}
