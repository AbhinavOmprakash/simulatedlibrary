package library;

import common.models.DataManager;
import common.models.FinancialAccount;
import common.models.Member;
import common.models.PaymentGateway;
import library.models.OverdueAccountant;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class TestOverdueAccountant {
    DataManager dataManager = mock(DataManager.class);
    PaymentGateway paymentGateway = mock(PaymentGateway.class);
    Member member = mock(Member.class);
    OverdueAccountant accountant = new OverdueAccountant(dataManager, paymentGateway);
    ArgumentCaptor<FinancialAccount> accountCaptor = ArgumentCaptor.forClass(FinancialAccount.class);

    @Test
    void AccountantShouldUpdateAccountsWithThePenaltyDue() {
        FinancialAccount account = new FinancialAccount(member.getUserName());
        when(dataManager.search(anyString())).thenReturn(account);
        when(member.getOverduePerDay()).thenReturn(10.0);

        Double previousFees = account.getFeesDue();

        accountant.initiatePayment(member, 10);

        verify(dataManager).updateData(accountCaptor.capture());
        FinancialAccount capturedAccount = accountCaptor.getValue();
        assertTrue(capturedAccount.getFeesDue() != 0.0);

        assertFalse(previousFees.equals(capturedAccount.getFeesDue()));
    }
}
