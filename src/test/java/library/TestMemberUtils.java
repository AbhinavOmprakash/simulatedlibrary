package library;

import common.models.DataManager;
import common.models.HibernateDB;
import common.models.Member;
import library.models.MemberUtils;
import library.models.libraryitems.LibraryItem;
import org.junit.jupiter.api.Test;
import setup.ObjectFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestMemberUtils {
    LibraryItem book1 = ObjectFactory.getTheFaultInOurStars();
    DataManager dataManager = mock(DataManager.class);
    MemberUtils memberUtils = new MemberUtils(dataManager);

    @Test
    void borrowNotPossibleWhenUserLimitIsReached() {
        when(dataManager.search(book1.getId())).thenReturn(null);
        Member member = ObjectFactory.getMember();
        // artificially setting limit to zero
        member.getMembershipLevel().setBorrowLimit(0);
        assertFalse(memberUtils.canUserBorrow(member));
    }

    @Test
    void testRealMemberBorrowLimitIs1() {
        HibernateDB db = new HibernateDB(true);
        DataManager dm = new DataManager(db, new Member());
        Member member = (Member) dm.search("ab");

        assertEquals(1, member.getBorrowLimit());


    }
}
