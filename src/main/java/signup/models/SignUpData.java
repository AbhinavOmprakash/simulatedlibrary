package signup.models;

import common.models.MembershipPolicy;
import member.models.MembershipPolicyManager;

import java.util.List;

@SuppressWarnings("rawtypes,unchecked")
public class SignUpData {
    private static final MembershipPolicyManager policyManager = new MembershipPolicyManager();

    protected String firstName;
    protected String lastName;
    protected String userName;
    protected char[] password;
    protected MembershipPolicy policy;

    public SignUpData(RawSignUpData data) {
        this.firstName = data.firstName;
        this.lastName = data.lastName;
        this.userName = data.userName;
        this.password = data.password;
        this.policy = getPolicy(data.policy);
    }
    // todo- refactor class is doing too much
    private MembershipPolicy getPolicy(String policyName) {
        List results = policyManager.search(String.valueOf(policyName));
        return (MembershipPolicy) results.get(0);
    }

}