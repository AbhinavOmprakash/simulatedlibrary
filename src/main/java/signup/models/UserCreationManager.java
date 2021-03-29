package signup.models;

import common.customevents.CustomEvent;
import common.customevents.EventCotroller;

public class UserCreationManager {

    public static void createUser(RawSignUpData data){

        EventCotroller eventCotroller = EventCotroller.getInstanceOf();
        eventCotroller.dispatch(CustomEvent.SIGNED_UP);
    }
}
