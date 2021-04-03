package member;

import common.MainRouter;
import common.Views;
import common.customevents.CustomEvent;
import common.Router;
import common.models.DisplayPage;
import member.views.MyAccount;
import member.views.UpgradeMembership;

import java.awt.event.ActionEvent;

@SuppressWarnings({"unchecked","rawtypes"})
public class MemberRouter extends Router{

    MyAccount myAccountPage;
    UpgradeMembership upgradePage;

    public MemberRouter(MainRouter router,
                        MyAccount myAccountPage, UpgradeMembership upgradePage) {
        super(router);
        this.myAccountPage = myAccountPage;
        this.upgradePage = upgradePage;

        myAccountPage.registerListener(this);
        upgradePage.registerListener(this);
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
