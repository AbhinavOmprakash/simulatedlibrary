package models.dataobjects.library.records;

public class SignUpData {
    public String firstName;
    public String lastName;
    public String userName;
    public char[] password;

    public SignUpData(String firstName, String lastName, String userName, char[] password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
    }
}
