package member.controllers;

import common.PaymentObserver;
import externalservices.DummyPayment;
import externalservices.PaymentGateway;
import member.models.Member;
import admin.models.MembershipFactory;
import member.models.membershiplevels.MembershipPolicy;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({"rawtypes","unchecked"})
public class UpgradeMembershipManager implements PaymentObserver {
    private PaymentGateway paymentGateway = new DummyPayment();
    private HashMap<Member, MembershipPolicy> upgradeQueue = new HashMap<>();

    public UpgradeMembershipManager() {
        paymentGateway.registerObservers(this);
    }

    public void upgradeMember(Member member, MembershipPolicy policy){
        upgradeQueue.put(member, policy);
        forwardToPaymentGateway(member, policy);
    }

    private void forwardToPaymentGateway(Member member, MembershipPolicy policy) {
        paymentGateway.acceptPayment((long) member.getID(), policy.membershipFees);
    }

    @Override
    public void receivePaymentStatus(Long userID, boolean status) {
        if (status){
            updateMembership(userID);
        }
    }
    //todo find a better name
    private void updateMembership(Long userID) {
        for(Map.Entry<Member, MembershipPolicy> entry: upgradeQueue.entrySet()){
            Member member = entry.getKey();
            MembershipPolicy policy = entry.getValue();
            if (member.getID()== userID){
                member.setMembershipLevel(MembershipFactory.createMembership(policy));
                System.out.println("upgraded membership");
                System.out.println(member.getMembershipLevel().getPolicy());
            }
        }
    }

}
