package common.models;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table( name = "User")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class User{
    private String firstName;
    private String lastName;
    private String userName;
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    protected int ID;

    public User() {
        // for hibernate
    }

    public User(String firstName, String lastName, String userName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
    }

    @Override
    public boolean equals(Object o ){
        if (o == this){
            return true;
        }

        if (!(o instanceof User)){
            return false;
        }
        User givenUser = (User) o;
        return this.getUserName().equals(givenUser.getUserName());
    }

    // getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

}