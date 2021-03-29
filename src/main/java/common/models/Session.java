package common.models;

public class Session{
    private static String currentUser;
    private static Session instance = new Session();

    private Session(){}

    public static String getCurrentUser() throws UnsupportedOperationException{
        if(currentUser==null){
            throw new UnsupportedOperationException("the current user has not been set");
        }
        return currentUser;
    }

    public static void setUser(String user){
        currentUser = user;
    }
    public static void removeUser(){
        currentUser = null;
    }

}
