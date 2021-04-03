package signup.models;

import common.factory.Assembler;
import common.factory.CleanData;
import common.factory.FactoryController;
import common.factory.Parts;
import common.models.Member;
import common.models.MembershipLevel;
import common.models.MembershipLevelFactory;

// todo add logic for upgrading the membership.
public class MemberAssembler extends Assembler<Member> {
    MembershipLevelFactory membershipLevelFactory;

    public MemberAssembler(FactoryController<Member> mainFactory,
                           MembershipLevelFactory membershipLevelFactory) {
        super(mainFactory, new Parts<>());
        this.membershipLevelFactory = membershipLevelFactory;
    }

    @Override
    protected void createParts(CleanData cleanData) {
        SignUpData data = (SignUpData) cleanData;
        MembershipLevel membership = membershipLevelFactory.createMembershipLevel(data.policy);
        parts.addPart("membership", membership);
    }

    @Override
    protected Member assemble(Parts<Member> parts) {
        Member member = parts.getMainPart();
        MembershipLevel membershipLevel = (MembershipLevel) parts.getPart("membership");
        member.setMembershipLevel(membershipLevel);
        return member;
    }
}
