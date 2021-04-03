package member;

import common.App;
import common.Dependency;
import common.models.*;
import library.models.*;
import member.controllers.UpgradePageController;
import member.models.MembershipUpgrader;
import member.views.MyAccount;
import member.views.UpgradeMembership;

public class MemberApp extends App {
    @Override
    protected void initializeObjects(Dependency dependency) {
        // data manager
        DataManager policies = new DataManager(dependency.dataBase, new MembershipPolicy());
        DataManager users = new DataManager(dependency.dataBase, new Member());
        DataManager borrowedItems = new DataManager(dependency.dataBase, new BorrowedItem());
        DataManager accounts = new DataManager(dependency.dataBase, new FinancialAccount());
        OverdueAccountant accountant = new OverdueAccountant(accounts, dependency.paymentGateway);
        // factories
        MembershipLevelFactory policyFactory = new MembershipLevelFactory(policies);
        // models
        LibraryUtils libraryUtils = new LibraryUtils(borrowedItems);
        MembershipUpgrader upgrader = new MembershipUpgrader(policyFactory, users, dependency.paymentGateway);
        NormalReturn normalReturn = new NormalReturn(borrowedItems, users);
        ReturnLibrarian librarian = new ReturnLibrarian(normalReturn,libraryUtils, accountant, dependency.paymentGateway);

        //views
        MyAccount accountPage = new MyAccount(librarian, users);
        UpgradeMembership upgradePage = new UpgradeMembership(policies, users);
        router = new MemberRouter(dependency.router, accountPage, upgradePage);
        addView(accountPage);
        addView(upgradePage);

        // controllers
        UpgradePageController upgradePageController = new UpgradePageController(upgradePage, policies, users, upgrader);
    }
}
