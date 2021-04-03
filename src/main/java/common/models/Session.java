package common.models;

public class Session{
    private static String currentUser = "ab";
    private static String accessPrivilege = Member.getAccessPrivilege();
    private static final Session instance = new Session();

    private Session() {}

    public static Session getInstanceOf() {
        return instance;
    }

    public static void setCurrentUser(String currentUser) {
        Session.currentUser = currentUser;
    }

    public static String getCurrentUser() {
        return currentUser;
    }

    public static void setAccessPrivilege(String accessPrivilege) {
        Session.accessPrivilege = accessPrivilege;
    }

    public static String getAccessPrivilege() {
        return accessPrivilege;
    }

    public static void removeUser(){
        currentUser = null;
    }

}
