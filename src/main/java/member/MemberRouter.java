package member;

import common.Views;
import common.customevents.CustomEvent;
import common.Router;
import common.models.DisplayPage;
import member.views.MyAccount;
import member.views.UpgradeMembership;

import java.awt.event.ActionEvent;

@SuppressWarnings({"unchecked","rawtypes"})
public class MemberRouter extends Router{

    MyAccount myAccountPage = new MyAccount(this);
    UpgradeMembership upgradePage = new UpgradeMembership(this);

    public MemberRouter(Router router) {
        super(router);
        registerView(myAccountPage);
        registerView(upgradePage);
    }

    @Override
    public void homeView() {
        setView(myAccountPage);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == upgradePage.backButton) {
            setView(myAccountPage);

        } else if (e.getSource() == upgradePage.upgradeButton) {
            parentRouter.changeView(Views.PAYMENT);

        } else if (e.getSource() == myAccountPage.upgradeMembershipButton) {
            setView(upgradePage);

        } else if (e.getSource() == myAccountPage.homeButton) {
            parentRouter.changeView(Views.LIBRARY_HOME);
        }
    }

}
