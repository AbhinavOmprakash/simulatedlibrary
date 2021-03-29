package signup.models;

import common.models.MembershipPolicy;

public class RawSignUpData {
    public String firstName;
    public String lastName;
    public String userName;
    public char[] password;
    public String policy;

    public RawSignUpData(String firstName, String lastName, String userName, char[] password, String policy) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.policy = policy;
    }
}
