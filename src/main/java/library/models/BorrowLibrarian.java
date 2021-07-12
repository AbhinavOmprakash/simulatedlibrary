package library.models;

import common.models.Member;
import library.models.libraryitems.LibraryItem;

public class BorrowLibrarian implements BorrowIncharge {
    BorrowIncharge normalBorrow;
    LibraryUtils libraryUtils;
    MemberUtils memberUtils;

    public BorrowLibrarian(BorrowIncharge normalBorrow, Utils utils) {
        this.normalBorrow = normalBorrow;
        this.libraryUtils = utils.libUtils;
        this.memberUtils = utils.memberUtils;
    }

    public void borrowItem(String username, LibraryItem item){
        Member member = memberUtils.getMember(username);
        if (libraryUtils.isNotBorrowed(item) && memberUtils.canUserBorrow(member)){
            normalBorrow.borrowItem(member, item);
        }
    }

    @Override
    public void borrowItem(Member member, LibraryItem item) {
        if (libraryUtils.isNotBorrowed(item) && memberUtils.canUserBorrow(member)){
            normalBorrow.borrowItem(member, item);
        }
    }
}
