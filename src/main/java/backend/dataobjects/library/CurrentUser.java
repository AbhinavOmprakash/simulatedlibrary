package backend.dataobjects.library;

import backend.controllers.UserDataManager;
import views.DataObserver;

import java.util.ArrayList;

@SuppressWarnings({"unchecked,rawtypes"})
public class CurrentUser{
    private static User currentUser;
    private static CurrentUser instance = new CurrentUser();

    private static ArrayList<DataObserver> observers = new ArrayList<>();

    private CurrentUser(){}

    public static void changeUser(User user){
        saveUserData();
        currentUser = user;
    }
    public static void removeUser(){
        saveUserData();
        currentUser = null;
    }

    public static User getCurrentUser() throws UnsupportedOperationException{
        if(currentUser==null){
            throw new UnsupportedOperationException("the current user has not been set");
        }
        return currentUser;
    }

    public static void saveUserData(){
        if(currentUser!=null){
            UserDataManager.getInstanceOf().updateData(currentUser);
        }

    }

}
