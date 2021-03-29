package library;

import common.models.DataManager;
import common.models.Member;
import library.models.BorrowIncharge;
import library.models.BorrowedItemsDataManager;
import library.models.libraryitems.LibraryItem;
import org.junit.jupiter.api.Test;
import setup.ObjectFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestBorrow {
    LibraryItem book1 = ObjectFactory.getTheFaultInOurStars();

    DataManager dataManager = mock(BorrowedItemsDataManager.class);
    BorrowIncharge borrowIncharge = new BorrowIncharge(dataManager);

    @Test
    void BorrowShouldAddItemToUserBorrowedItems() {
        when(dataManager.search(book1.getId())).thenReturn(book1);

        Member member = ObjectFactory.getMember();
        borrowIncharge.borrowItem(member, book1);
        List<LibraryItem> borrowed = member.getBorrowedItems();
        assertTrue(borrowed.contains(book1));
    }

    @Test
    void borrowNotPossibleWhenItemIsCheckedOut() {
        when(dataManager.search(book1.getId())).thenReturn(null);
        Member member = ObjectFactory.getMember();
        assertFalse(borrowIncharge.borrowPossible(member,book1));
    }

    @Test
    void borrowNotPossibleWhenUserLimitIsReached() {
        when(dataManager.search(book1.getId())).thenReturn(null);
        Member member = ObjectFactory.getMember();
        // artificially setting limit to zero
        member.getMembershipLevel().setBorrowLimit(0);
        assertFalse(borrowIncharge.borrowPossible(member,book1));
    }
}
