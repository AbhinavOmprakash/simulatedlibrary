package member.controllers;

import common.models.DataManager;
import common.models.Member;
import common.models.MembershipPolicy;
import member.models.MembershipUpgrader;

public class UpgradeMembershipController {
    private DataManager userDataManager;
    private DataManager membershipDataManager;
    private MembershipUpgrader membershipUpgrader;

    public UpgradeMembershipController(DataManager userDataManager,
                                       DataManager membershipDataManager,
                                       MembershipUpgrader membershipUpgrader) {
        this.userDataManager = userDataManager;
        this.membershipDataManager = membershipDataManager;
        this.membershipUpgrader = membershipUpgrader;
    }

    public void upgradeMember(String username, String policy) {
        MembershipPolicy membershipPolicy = getPolicyFromDB(policy);
        Member member = getMemberFromDB(username);
        membershipUpgrader.upgrade(member, membershipPolicy);
    }

    private MembershipPolicy getPolicyFromDB(String policy){
        return (MembershipPolicy) membershipDataManager.search(policy);
    }

    private Member getMemberFromDB(String username) {
        return (Member) userDataManager.search(username);
    }

}
