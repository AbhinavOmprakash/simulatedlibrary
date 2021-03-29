package library;

import common.models.DataManager;
import common.models.Member;
import library.models.*;
import library.models.libraryitems.LibraryItem;
import org.junit.jupiter.api.Test;
import setup.ObjectFactory;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestLibrarian {
    LibraryItem book1 = ObjectFactory.getTheFaultInOurStars();
    LibraryItem book2 = ObjectFactory.getBookWillGreyson();

    DataManager dataManager = mock(BorrowedItemsDataManager.class);
    BorrowIncharge borrowIncharge = new BorrowIncharge(dataManager);
    ReturnIncharge returnIncharge = new ReturnIncharge(dataManager);
    Librarian librarian = new Librarian(borrowIncharge, returnIncharge);

    @Test
    void UserCannotBorrowMoreThanLimit() {
        when(dataManager.search(book1.getId())).thenReturn(book1);
        when(dataManager.search(book2.getId())).thenReturn(book2);

        Member member = ObjectFactory.getMember();
        int borrowLimit = member.getMembershipLevel().getBorrowLimit();

        librarian.borrowItem(member, book1);
        List<LibraryItem> borrowed = member.getBorrowedItems();
        assertEquals(borrowLimit,borrowed.size());
    }

    @Test
    void UserCantBorrowCheckedOutItem(){
        when(dataManager.search(book1.getId())).thenReturn(null);
        Member member = ObjectFactory.getMember();
        librarian.borrowItem(member, book1);

        List<LibraryItem> borrowed = member.getBorrowedItems();
        assertFalse(borrowed.contains(book1));
    }

    @Test
    void ItemCannotBeReturnedIfOverDue() {
        Member member = ObjectFactory.getMember();
        member.addBorrowedItem(book1);

        BorrowedItem overdueItem = new BorrowedItem(book1);
        LocalDateTime overdueBorrowedOnDate = LocalDateTime.of(2020,1,1,1,10);
        overdueItem.setBorrowedOn(overdueBorrowedOnDate);

        when(dataManager.search(book1.getId())).thenReturn(overdueItem);

        librarian.returnItem(member, book1);
        assertTrue(member.getBorrowedItems().contains(book1));
    }
}
