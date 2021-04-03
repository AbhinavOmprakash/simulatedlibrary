package library.models;

import common.models.Member;
import library.models.libraryitems.LibraryItem;

public interface BorrowIncharge {
    void borrowItem(Member member, LibraryItem item);
}
