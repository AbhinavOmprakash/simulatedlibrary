package signup.models;

import member.models.membershiplevels.MembershipPolicy;

public class SignUpData {
    public String firstName;
    public String lastName;
    public String userName;
    public char[] password;
    public MembershipPolicy policy;

    public SignUpData(String firstName, String lastName, String userName, char[] password, MembershipPolicy policy) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.policy = policy;
    }
}
