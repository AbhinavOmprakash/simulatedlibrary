package library.models;

import common.models.DataManager;
import common.models.Member;

public class MemberUtils {
    private final DataManager users;

    public MemberUtils(DataManager users) {
        this.users = users;
    }

    public boolean canUserBorrow(String username){
        Member user = getMember(username);
        return canUserBorrow(user);
    }

    public Member getMember(String username){
        return (Member) users.search(username);
    }

    public boolean canUserBorrow(Member user){
        int borrowLimit = user.getBorrowLimit();
        int numBorrowedItems = user.totalBorrowedItems();
        return (numBorrowedItems < borrowLimit);
    }
}
