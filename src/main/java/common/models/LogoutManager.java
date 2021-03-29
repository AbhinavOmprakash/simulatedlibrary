package common.models;

import common.customevents.CustomEvent;
import common.customevents.EventCotroller;

public class LogoutManager {

    public static void logout(){
        EventCotroller.getInstanceOf().dispatch(CustomEvent.LOG_OUT);
    }
}
