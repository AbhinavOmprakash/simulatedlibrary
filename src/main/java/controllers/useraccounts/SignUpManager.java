package controllers.useraccounts;

import controllers.DataManager;
import controllers.financials.AccountsDataManager;
import models.dataobjects.library.Member;
import models.dataobjects.library.membershiplevels.MembershipFactory;
import models.dataobjects.library.records.FinancialAccount;
import models.dataobjects.library.records.LoginData;
import models.dataobjects.library.records.SignUpData;

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
