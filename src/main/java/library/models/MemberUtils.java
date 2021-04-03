package library.models;

import common.models.DataManager;
import common.models.Member;

public class MemberUtils {
    private final DataManager users;

    public MemberUtils(DataManager users) {
        this.users = users;
    }

    public boolean userCanBorrow(String username){
        Member user = getMember(username);
        return userCanBorrow(user);
    }

    public Member getMember(String username){
        return (Member) users.search(username);
    }

    public boolean userCanBorrow(Member user){
        int borrowLimit = user.getBorrowLimit();
        int numBorrowedItems = user.totalBorrowedItems();
        return (numBorrowedItems + 1 <= borrowLimit); //todo is this obvious? or is this - (borrowedItems < borrowLimit)
    }
}
