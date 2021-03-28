package common.models;

import common.customevents.CustomEvent;
import common.customevents.EventListener;
import member.models.UserDataManager;

import java.util.ArrayList;

@SuppressWarnings({"unchecked,rawtypes"})
public class CurrentUser implements EventListener {
    private static User currentUser;
    private static CurrentUser instance = new CurrentUser();

    private static ArrayList<DataObserver> observers = new ArrayList<>();

    private CurrentUser(){}

    public static User getCurrentUser() throws UnsupportedOperationException{
        if(currentUser==null){
            throw new UnsupportedOperationException("the current user has not been set");
        }
        return currentUser;
    }

    @Override
    public void receive(CustomEvent event) {
        if(event.equals(CustomEvent.LOG_OUT)){
            removeUser();
        }
    }

    private static void removeUser(){
        saveUserData();
        currentUser = null;
    }

    public static void changeUser(User user){
        saveUserData();
        currentUser = user;
    }

    public static void saveUserData(){
        if(currentUser!=null){
            UserDataManager.getInstanceOf().updateData(currentUser);
        }
    }

}
