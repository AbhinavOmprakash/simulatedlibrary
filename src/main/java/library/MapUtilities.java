package library;
import static org.mockito.ArgumentMatchers.refEq;

import java.util.ArrayList;
import java.util.Map;

public class MapUtilities {

    public static <K, V> ArrayList<K> getAllKeysForValue(Map<K, ArrayList<V>> mapData, V value) {
        ArrayList<K> listOfKeys = new ArrayList<>();

        for(Map.Entry<K, ArrayList<V>> entry : mapData.entrySet()){
            if (entry.getValue().contains(value)) {
                listOfKeys.add(entry.getKey());
            }

        }
        return listOfKeys;
    }

    
}
