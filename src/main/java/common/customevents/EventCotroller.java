package common.customevents;

import java.util.ArrayList;

public class EventCotroller {
    private static EventCotroller instance = new EventCotroller();

    private final ArrayList<EventListener> listeners = new ArrayList<>();

    private EventCotroller(){
    }

    public void registerListener(EventListener listener){
        synchronized (listeners) {
            listeners.add(listener);
        }
    }

    public void removeListener(EventListener listener){
        listeners.remove(listener);
    }

    public void dispatch(CustomEvent event){
        for (EventListener listener: listeners){
            listener.receive(event);
        }
    }

    public static EventCotroller getInstanceOf() {
        return instance;
    }

}
