package library;

import common.models.DataManager;
import common.models.Member;
import library.models.BorrowedItemsDataManager;
import library.models.NormalReturn;
import library.models.libraryitems.LibraryItem;
import org.junit.jupiter.api.Test;
import setup.ObjectFactory;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

public class TestNormalReturn {
    LibraryItem book1 = ObjectFactory.getTheFaultInOurStars();
    DataManager dataManager = mock(BorrowedItemsDataManager.class);
    NormalReturn normalReturn = new NormalReturn(dataManager);

    @Test
    void AssertItemNotWithUserAfterReturn() {
        Member member = ObjectFactory.getMember(); member.borrowItem(book1);
        assertTrue(member.hasBorrowed(book1));

        normalReturn.returnItem(member,book1);

        assertFalse(member.hasBorrowed(book1));
    }

}
