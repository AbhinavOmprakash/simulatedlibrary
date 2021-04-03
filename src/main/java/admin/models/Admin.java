package admin.models;

import common.models.User;

import javax.persistence.Entity;

@Entity
public class Admin extends User {
    public Admin() {
        // for hibernate
    }

    public static String getAccessPrivilege(){
        return "admin";
    }

    public Admin(String firstName, String lastName, String userName) {
        super(firstName, lastName, userName);
    }
}
