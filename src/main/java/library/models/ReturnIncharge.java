package library.models;

import common.models.Member;
import library.models.libraryitems.LibraryItem;

public interface ReturnIncharge {
    void returnItem(Member member, LibraryItem item);
}
