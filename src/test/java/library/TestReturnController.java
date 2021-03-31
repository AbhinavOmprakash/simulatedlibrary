package library;

import common.Transaction;
import common.models.DataManager;
import common.models.Member;
import common.models.PaymentGateway;
import library.models.*;
import library.models.libraryitems.LibraryItem;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import payment.models.DummyPayment;
import setup.ObjectFactory;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

public class TestReturnController {
    LibraryItem book1 = ObjectFactory.getTheFaultInOurStars();

    DataManager dataManager = mock(BorrowedItemsDataManager.class);
    OverdueAccountant accountant = mock(OverdueAccountant.class);
    PaymentGateway paymentGateway = mock(PaymentGateway.class);

    ReturnController returnController = new ReturnController(dataManager, accountant, paymentGateway);

    @Test
    void ItemCanBeReturnedIfPaymentSucceeds() {
        Member member = ObjectFactory.getMember();
        member.borrowItem(book1);

        BorrowedItem overdueItem = new BorrowedItem(book1);
        LocalDateTime overdueBorrowedOnDate = LocalDateTime.of(2020,1,1,1,10);
        overdueItem.setBorrowedOn(overdueBorrowedOnDate);

        when(dataManager.search(book1.getId())).thenReturn(overdueItem);

        doAnswer((i) -> {
            returnController.receivePaymentStatus(member.getUserName(), true, 12.03, Transaction.OVERDUE_FEES);
            return null;
        }).when(accountant).initiatePayment(any(), anyInt());

        returnController.returnItem(member, book1);

        assertFalse(member.hasBorrowed(book1));
    }

    @Test
    void returnFailsIfPaymentFails() {
        Member member = ObjectFactory.getMember();
        member.borrowItem(book1);

        BorrowedItem overdueItem = new BorrowedItem(book1);
        LocalDateTime overdueBorrowedOnDate = LocalDateTime.of(2020,1,1,1,10);
        overdueItem.setBorrowedOn(overdueBorrowedOnDate);

        when(dataManager.search(book1.getId())).thenReturn(overdueItem);

        doAnswer((i) -> {
            returnController.receivePaymentStatus(member.getUserName(),false, 12.03, Transaction.OVERDUE_FEES);
            return null;
        }).when(accountant).initiatePayment(any(), anyInt());

        returnController.returnItem(member, book1);

        assertTrue(member.hasBorrowed(book1));
    }
}
