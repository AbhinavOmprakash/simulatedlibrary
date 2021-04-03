package library.models;

public class Utils {
    public LibraryUtils libUtils;
    public MemberUtils memberUtils;

    public Utils(LibraryUtils libUtils, MemberUtils memberUtils) {
        this.libUtils = libUtils;
        this.memberUtils = memberUtils;
    }

    public LibraryUtils getLibUtils() {
        return libUtils;
    }

    public void setLibUtils(LibraryUtils libUtils) {
        this.libUtils = libUtils;
    }

    public MemberUtils getMemberUtils() {
        return memberUtils;
    }

    public void setMemberUtils(MemberUtils memberUtils) {
        this.memberUtils = memberUtils;
    }
}
