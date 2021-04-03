package signup;

import common.Dependency;
import common.App;
import common.factory.Factory;
import common.factory.FactoryController;
import common.models.*;
import login.models.LoginData;
import signup.controllers.SignUpGuiController;
import signup.models.CredentialCreator;
import signup.models.MemberAssembler;
import signup.models.NewFinAccount;
import signup.models.NewMember;
import signup.views.SignUpPage;

public class SignUpApp extends App {
    @Override
    protected void initializeObjects(Dependency dependency) {
        //Data Managers
        DataManager members = new DataManager(dependency.dataBase, new Member());
        //todo change back to policy
        DataManager allPolicies = new DataManager(dependency.dataBase, new MembershipPolicy());
        DataManager loginData = new DataManager(dependency.dataBase, new LoginData());
        DataManager accounts = new DataManager(dependency.dataBase, new FinancialAccount());

        // Views
        SignUpPage page = new SignUpPage(allPolicies);
        addView(page);

        router = new SignUpRouter(dependency.router, page);

        // factories
        Factory<LoginData> loginFactory= new CredentialCreator();
        Factory<Member> memberFactory= new NewMember();
        Factory<FinancialAccount> accountFactory = new NewFinAccount();
        MembershipLevelFactory membershipFactory = new MembershipLevelFactory(allPolicies);

        // controllers
        FactoryController<LoginData> loginFactoryController = new FactoryController<>(loginData, loginFactory);
        FactoryController<Member> memberFactoryController = new FactoryController<>(members, memberFactory);
        FactoryController<FinancialAccount> accountFactoryController = new FactoryController<>(accounts, accountFactory);

        // Assemblers
        MemberAssembler memberAssembler = new MemberAssembler(memberFactoryController, membershipFactory);

        SignUpGuiController guiController = new SignUpGuiController(page, memberAssembler, loginFactoryController);

    }
}
