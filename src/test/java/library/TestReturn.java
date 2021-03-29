package library;

import common.models.DataManager;
import common.models.Member;
import library.models.BorrowedItem;
import library.models.BorrowedItemsDataManager;
import library.models.ReturnIncharge;
import library.models.libraryitems.LibraryItem;
import org.junit.jupiter.api.Test;
import setup.ObjectFactory;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestReturn {
    LibraryItem book1 = ObjectFactory.getTheFaultInOurStars();
    DataManager dataManager = mock(BorrowedItemsDataManager.class);
    ReturnIncharge returnIncharge = new ReturnIncharge(dataManager);

    @Test
    void AssertItemNotWithUserAfterReturn() {
        Member member = ObjectFactory.getMember(); member.addBorrowedItem(book1);
        assertTrue(member.getBorrowedItems().contains(book1));

        returnIncharge.returnItem(member,book1);
        assertFalse(member.getBorrowedItems().contains(book1));
    }

    @Test
    void ItemShouldReturnTrueForOverdue(){
        Member member = ObjectFactory.getMember();
        member.addBorrowedItem(book1);
        LocalDateTime overdueBorrowedOnDate = LocalDateTime.of(2020, 1, 1, 1, 10);
        BorrowedItem overdueItem = new BorrowedItem(book1);
        overdueItem.setBorrowedOn(overdueBorrowedOnDate);
        when(dataManager.search(book1.getId())).thenReturn(overdueItem);

        assertTrue(returnIncharge.isOverdue(book1));
    }


}
