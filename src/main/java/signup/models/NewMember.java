package signup.models;

import common.factory.CleanData;
import common.factory.Factory;
import common.models.DataManager;
import common.models.Member;
import common.models.MembershipLevelFactory;

public class NewMember implements Factory<Member> {
    @Override
    public Member create(CleanData cleanData) {
        SignUpData data = (SignUpData) cleanData;
        return new Member(data.firstName, data.lastName, data.userName);
    }
}
