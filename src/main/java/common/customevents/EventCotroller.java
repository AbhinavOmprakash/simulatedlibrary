package common.customevents;

import java.util.ArrayList;

public class EventCotroller {
    private static EventCotroller instance = new EventCotroller();

    private final ArrayList<CustomEventListener> listeners = new ArrayList<>();

    private EventCotroller(){
    }

    public void registerListener(CustomEventListener listener){
        synchronized (listeners) {
            listeners.add(listener);
        }
    }

    public void removeListener(CustomEventListener listener){
        listeners.remove(listener);
    }

    public void dispatch(CustomEvent event){
        System.out.println(event.toString());
        for (CustomEventListener listener: listeners){
            listener.receive(event);
        }
    }

    public static EventCotroller getInstanceOf() {
        return instance;
    }

}
