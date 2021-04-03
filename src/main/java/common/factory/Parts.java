package common.factory;

import java.util.HashMap;
import java.util.Map;

public class Parts<T> {
    // data object that contains the parts to be assembled.
    T mainPart;
    Map<String, Object> parts = new HashMap<>();

    public void addMainPart(T mainPart){
        this.mainPart= mainPart;
    }

    public void addPart(String identifier, Object part){
        parts.put(identifier, part);
    }

    public T getMainPart() {
        return mainPart;
    }

    public Object getPart(String identifier) {
        return parts.get(identifier);
    }
}
