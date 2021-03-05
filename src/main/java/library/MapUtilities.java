package library;
import static org.mockito.ArgumentMatchers.refEq;

import java.util.ArrayList;
import java.util.Map;

public class MapUtilities {

    static <K, V, T> ArrayList<K> getAllKeysForValue(Map<K, V> mapData, T value) {
        ArrayList<K> listOfKeys = new ArrayList<>();

        if (mapData.containsValue(value)) {
            for(Map.Entry<K, V> entry : mapData.entrySet()){
                if (entry.getKey().equals(value)) {
                    listOfKeys.add(entry.getKey());
                }

            }
        }
        return listOfKeys;
    }

    
}
