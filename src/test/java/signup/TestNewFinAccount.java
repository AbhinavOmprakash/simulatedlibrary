package signup;

import common.models.DataManager;
import common.models.FinancialAccount;
import common.models.Member;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import setup.ObjectFactory;
import signup.models.NewFinAccount;
import signup.models.NewMember;
import signup.models.SignUpData;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TestNewFinAccount {
    SignUpData signUpData = ObjectFactory.getBasicSignUpData(); //test data
    DataManager mockDataManager = mock(DataManager.class);

    NewFinAccount newFinAccount = new NewFinAccount(mockDataManager);
    ArgumentCaptor<FinancialAccount> financialAccountCaptor = ArgumentCaptor.forClass(FinancialAccount.class);

    @Test
    void properFinancialAccountIsCreated() {
        FinancialAccount expectedFinAccount = new FinancialAccount(signUpData.userName);

        newFinAccount.create(signUpData);

        verify(mockDataManager).addItem(financialAccountCaptor.capture());

        FinancialAccount actualAccount = financialAccountCaptor.getValue();

        assertEquals(expectedFinAccount.getUsername(), actualAccount.getUsername());
        assertEquals(expectedFinAccount.getFeesDue(), actualAccount.getFeesDue());
    }

}
