package signup.models;

import common.models.DataManager;
import common.models.Member;
import common.models.MembershipFactory;
import member.models.UserDataManager;

@SuppressWarnings({"unchecked","rawtypes"})
public class CreateNewMember {

    private static DataManager userDataManager = UserDataManager.getInstanceOf();

    public static void createMember(SignUpData data) {
        Member member = new Member(data.firstName, data.lastName, data.userName,
                MembershipFactory.createMembership(data.policy));
        userDataManager.addItem(member);
    }
}
