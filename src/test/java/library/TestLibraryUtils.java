package library;

import common.models.DataManager;
import common.models.Member;
import library.models.BorrowedItem;
import library.models.LibraryUtils;
import library.models.libraryitems.LibraryItem;
import org.junit.jupiter.api.Test;
import setup.ObjectFactory;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestLibraryUtils {
    LibraryItem book1 = ObjectFactory.getTheFaultInOurStars();
    DataManager dataManager = mock(DataManager.class);
    LibraryUtils libraryUtils = new LibraryUtils(dataManager);

    @Test
    void ItemShouldReturnTrueForOverdue(){
        Member member = ObjectFactory.getMember();
        member.borrowItem(book1);
        LocalDateTime overdueBorrowedOnDate = LocalDateTime.of(2020, 1, 1, 1, 10);
        BorrowedItem overdueItem = new BorrowedItem(book1);
        overdueItem.setBorrowedOn(overdueBorrowedOnDate);
        when(dataManager.search(book1.getId())).thenReturn(overdueItem);

        assertTrue(libraryUtils.isOverdue(book1));
    }

    @Test
    void borrowNotPossibleWhenItemIsCheckedOut() {
        BorrowedItem borrowedItem = new BorrowedItem(book1);
        when(dataManager.search(book1.getId())).thenReturn(borrowedItem);
        Member member = ObjectFactory.getMember();
        assertFalse(libraryUtils.isOverdue(book1));
    }

}
