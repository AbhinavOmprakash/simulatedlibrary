package library.models;

import common.models.Member;
import library.models.libraryitems.LibraryItem;

public class ReturnTransaction {
    public Member member;
    public LibraryItem item;

    public ReturnTransaction(Member member, LibraryItem item) {
        this.member = member;
        this.item = item;
    }
}
