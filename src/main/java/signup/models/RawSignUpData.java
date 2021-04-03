package signup.models;

import common.factory.CleanData;
import common.factory.RawData;
import common.models.MembershipPolicy;

import java.util.Arrays;

public class RawSignUpData implements RawData {
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

    @Override
    public CleanData getCompatibleData() {
        return new SignUpData(firstName,
                lastName,
                userName,
                Arrays.toString(password),
                policy);
    }
}
