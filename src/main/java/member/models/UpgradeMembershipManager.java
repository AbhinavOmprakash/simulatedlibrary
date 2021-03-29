package member.models;

import common.Transaction;
import common.models.PaymentObserver;
import payment.models.DummyPayment;
import common.models.PaymentGateway;
import common.models.Member;
import common.models.MembershipFactory;
import common.models.MembershipPolicy;

import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({"rawtypes","unchecked"})
public class UpgradeMembershipManager implements PaymentObserver {
    private final PaymentGateway paymentGateway = DummyPayment.getInstanceOf();
    private HashMap<Member, MembershipPolicy> upgradeQueue = new HashMap<>();

    public UpgradeMembershipManager() {
        paymentGateway.registerObservers(this);
    }

    public void upgradeMember(Member member, MembershipPolicy policy){
        upgradeQueue.put(member, policy);
        forwardToPaymentGateway(member, policy);
    }

    private void forwardToPaymentGateway(Member member, MembershipPolicy policy) {
        paymentGateway.initializePayment(member.getUserName(), policy.membershipFees, Transaction.UPGRADE);
    }

    @Override
    public void receivePaymentStatus(String username, boolean status, double targetAmount, Transaction transaction) {
        if(transaction.equals(Transaction.UPGRADE) && status) {
            updateMembership(username);
        }
    }

    //todo find a better name.
    private void updateMembership(String username) {
        for(Map.Entry<Member, MembershipPolicy> entry: upgradeQueue.entrySet()){
            Member member = entry.getKey();
            MembershipPolicy policy = entry.getValue();
            if (member.getUserName()==username){
                member.setMembershipLevel(MembershipFactory.createMembership(policy));
                System.out.println("upgraded membership");
                System.out.println(member.getMembershipLevel().getPolicy());
            }
        }
    }


}
