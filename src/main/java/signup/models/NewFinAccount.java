package signup.models;

import common.factory.CleanData;
import common.factory.Factory;
import common.models.DataManager;
import common.models.FinancialAccount;

public class NewFinAccount implements Factory<FinancialAccount> {
    @Override
    public FinancialAccount create(CleanData cleanData) {
        SignUpData data = (SignUpData) cleanData;
        return new FinancialAccount(data.userName);
    }
}
