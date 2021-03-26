package signup.models;

import common.models.DataManager;
import member.controllers.UserDataManager;
import login.controllers.LoginDataManager;
import common.models.Member;
import admin.models.MembershipFactory;
import login.models.LoginData;

import java.util.List;

@SuppressWarnings({"rawtypes","unchecked"})
public class SignUpManager{
    DataManager userDataManager = UserDataManager.getInstanceOf();
    DataManager loginDataManager = new LoginDataManager();
    DataManager accountsDataManager = new AccountsDataManager();

    public boolean signUp(SignUpData data){
        createMember(data);
        createLoginData(data);
        createFinancialAccount(data);
        return true;
    }

    private void createFinancialAccount(SignUpData data) {
        List results = userDataManager.search(data.userName);
        Member newMember = (Member) results.get(0);
        FinancialAccount account = new FinancialAccount(newMember.getID());
        accountsDataManager.addItem(account);
    }

    private void createLoginData(SignUpData data) {
        LoginData loginData = new LoginData(data.userName, data.password);
        loginDataManager.addItem(loginData);
    }


    private void createMember(SignUpData data) {
        Member member = new Member(data.firstName, data.lastName, data.userName,
                MembershipFactory.createMembership(data.policy));
        userDataManager.addItem(member);
    }


}
