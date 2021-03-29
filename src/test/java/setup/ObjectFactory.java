package setup;

import admin.models.Admin;
import common.models.Member;
import common.models.MembershipLevel;
import common.models.MembershipPolicy;
import library.models.contributors.Author;
import library.models.contributors.Contributor;
import library.models.libraryitems.AudioBook;
import library.models.libraryitems.Book;
import library.models.libraryitems.LibraryItem;
import login.models.LoginData;
import login.models.RawLoginData;
import org.springframework.security.crypto.bcrypt.BCrypt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ObjectFactory {

    public static Contributor getJohnGreen(){
        return new Author("John Green");
    }

    public static Contributor getDavidLevithan(){
        return new Author("David Levithan");
    }

    public static ArrayList<Contributor> getContributorsForWillGreyson(){
        ArrayList<Contributor> contributorsWillGreyson =
                new ArrayList<>(Arrays.asList(getJohnGreen(), getDavidLevithan()));
        return contributorsWillGreyson;
    }

    public static ArrayList<Contributor> getContributorsTFIOS() {
        return new ArrayList<>(Collections.singletonList(getJohnGreen()));
    }

    public static LibraryItem getBookWillGreyson() {
        LibraryItem willGreyson = new Book("Will Greyson,Will Greyson",
                "YA",
                123456789,
                getContributorsForWillGreyson(),
                true,
                999999999);

        return willGreyson;
    }

    public static LibraryItem getAudioBookWillGreyson() {
        LibraryItem audioWillGreyson = new AudioBook("Will Greyson,Will Greyson",
                "YA",
                123456789,
                getContributorsForWillGreyson(),
                true,
                999999999);
        return audioWillGreyson;
    }

    public static LibraryItem getTheFaultInOurStars() {
        return new AudioBook("The fault in our stars",
                "Young Adult, Romance",
                13427890,
                getContributorsTFIOS(),
                true,
                91234821);
    }

    public static MembershipPolicy getBasicPolicy(){
        return new MembershipPolicy("Basic",10.0,
                1.0 ,1,
                0.0, 12);
    }

    public static MembershipPolicy getGoldPolicy(){
        return new MembershipPolicy("Gold",100.0,
                0.005 ,3,
                0.0, 12);
    }

    public static Member getMember(){
        return new Member("Abhinav", "Omprakash", "ab",
                new MembershipLevel(getBasicPolicy()));
    }

    public static LoginData getMemberlogin() {
        String passwd = BCrypt.hashpw("aww", BCrypt.gensalt());
        return new LoginData("ab", passwd);
    }

    public static RawLoginData getRawMemberlogin() {
        return new RawLoginData("ab","aww");
    }
    public static Admin getAdmin(){
        return new Admin("Deepak", "Yadav", "admin");
    }

    public static LoginData getAdminLogin() {
        String passwd = BCrypt.hashpw("JavaSucks", BCrypt.gensalt());
        return new LoginData("admin", passwd);
    }

    public static RawLoginData getRawAdminLogin() {
        return new RawLoginData("admin","JavSucks");
    }
}
