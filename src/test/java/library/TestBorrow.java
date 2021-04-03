package library;

import common.models.BorrowedItems;
import common.models.DataManager;
import common.models.Member;
import library.models.NormalBorrow;
import library.models.libraryitems.LibraryItem;
import org.junit.jupiter.api.Test;
import setup.ObjectFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestBorrow {
    LibraryItem book1 = ObjectFactory.getTheFaultInOurStars();

    DataManager dataManager = mock(DataManager.class);
    NormalBorrow normalBorrow = new NormalBorrow(dataManager, dataManager);

    @Test
    void BorrowShouldAddItemToUserBorrowedItems() {
        when(dataManager.search(book1.getId())).thenReturn(book1);

        Member member = ObjectFactory.getMember();
        normalBorrow.borrowItem(member, book1);
        assertTrue(member.hasBorrowed(book1));
    }

}
