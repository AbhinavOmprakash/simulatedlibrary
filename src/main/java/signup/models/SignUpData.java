package signup.models;

import common.factory.CleanData;

public class SignUpData implements CleanData {

    public String firstName;
    public String lastName;
    public String userName;
    public String password;
    public String policy;

    public SignUpData(String firstName,
                      String lastName,
                      String userName,
                      String password,
                      String policy) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.policy = policy;
    }

}