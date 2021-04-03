package library;

import common.models.DataManager;
import common.models.Member;
import library.models.*;
import library.models.libraryitems.LibraryItem;
import org.junit.jupiter.api.Test;
import setup.ObjectFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestBorrowLibrarian {
    LibraryItem book1 = ObjectFactory.getTheFaultInOurStars();
    LibraryItem book2 = ObjectFactory.getBookWillGreyson();

    DataManager dataManager = mock(DataManager.class);
    LibraryUtils libraryUtils = new LibraryUtils(dataManager);
    MemberUtils memberUtils = new MemberUtils(dataManager);
    Utils utils = new Utils(libraryUtils, memberUtils);
    NormalBorrow normalBorrow = new NormalBorrow(dataManager, dataManager);

    BorrowLibrarian borrowLibrarian = new BorrowLibrarian(normalBorrow, utils);

    @Test
    void UserCannotBorrowMoreThanLimit() {
        when(dataManager.search(book1.getId())).thenReturn(book1);
        when(dataManager.search(book2.getId())).thenReturn(book2);

        Member member = ObjectFactory.getMember();
        int borrowLimit = member.getBorrowLimit();

        borrowLibrarian.borrowItem(member, book1);
        assertEquals(borrowLimit, member.totalBorrowedItems());
    }

    @Test
    void UserCantBorrowCheckedOutItem(){
        when(dataManager.search(book1.getId())).thenReturn(null);
        Member member = ObjectFactory.getMember();
        borrowLibrarian.borrowItem(member, book1);
        assertFalse(member.hasBorrowed(book1));
    }
}
