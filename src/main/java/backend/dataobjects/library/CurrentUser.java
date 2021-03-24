package backend.dataobjects.library;

public class CurrentUser{
    private static User currentUser;
    private static CurrentUser instance = new CurrentUser();

    private CurrentUser(){}

    public static void changeUser(User user){
        currentUser = user;
    }
    public static void removeUser(){
        currentUser = null;
    }

    public static User getCurrentUser() throws UnsupportedOperationException{
        if(currentUser==null){
            throw new UnsupportedOperationException("the current user has not been set");
        }
        return currentUser;
    }
}
