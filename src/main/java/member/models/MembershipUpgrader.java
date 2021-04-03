package member.models;

import common.Transaction;
import common.models.*;

import java.util.HashMap;
import java.util.Map;

public class MembershipUpgrader implements PaymentObserver {
    private final PaymentGateway paymentGateway;
    private MembershipLevelFactory membershipLevelFactory;
    private DataManager users;

    private HashMap<Member, MembershipPolicy> upgradeQueue = new HashMap<>();

    public MembershipUpgrader(MembershipLevelFactory membershipLevelFactory,
                DataManager users, PaymentGateway paymentGateway) {
        this.membershipLevelFactory = membershipLevelFactory;
        this.users = users;
        this.paymentGateway = paymentGateway;
        paymentGateway.registerObservers(this);
    }

    public void upgrade(Member member, MembershipPolicy policy){
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
            System.out.println("upgrade manager upgrading membership");
        }
    }

    //todo find a better name.
    private void updateMembership(String username) {
        for(Map.Entry<Member, MembershipPolicy> entry: upgradeQueue.entrySet()){
            Member member = entry.getKey();
            MembershipPolicy policy = entry.getValue();

            if (member.getUserName()==username){
                member.setMembershipLevel(membershipLevelFactory.createMembershipLevel(policy));
                System.out.println("upgraded membership");
                System.out.println(member.getMembershipLevel().getPolicy());
                users.updateData(member);
            }
        }
    }
}
