package librarytest;

import backend.externalservices.Cache;
import backend.externalservices.DataStoreInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class testCache<K, V> {
    private Cache<K,V> dataCache;

    K key1 = (K) ("key1");
    K key2 = (K) ("key2");
    K key3 = (K) ("key3");
    K key4 = (K) ("key4");

    V valA = (V) ("val A");
    V valB = (V) ("val B");
    V valC = (V) ("val C");

    ArrayList<V> values1 = new ArrayList<>(Arrays.asList(valA, valB, valC));
    ArrayList<V> values2 = new ArrayList<>(Arrays.asList(valA, valB, valC));
    ArrayList<V> values3 = new ArrayList<>(Arrays.asList(valA, valB, valC));
    ArrayList<V> values4 = new ArrayList<>(Arrays.asList(valA, valB, valC));

    ArrayList<V> emptyListOfVitems = new ArrayList<>();

    @Mock
    DataStoreInterface<K,V> mockDatabase;

    @BeforeEach
    public void setUp() {
        dataCache = new Cache<>(mockDatabase, 3);
    }

    @Test
    public void testIfCapacityIsCorrectlySet() {
        int currentCapacity = dataCache.getCapacity();

        assertEquals(currentCapacity, 3);
    }

    @Test
    public void testIfCapacityCanBeChanged(){
        int oldCapacity = dataCache.getCapacity();
        dataCache.setCapacity(5);

        int newCapacity = dataCache.getCapacity();

        assertEquals(newCapacity, 5);
        assertNotEquals(newCapacity, oldCapacity);
    }

    @Test
    public void testDataCanBeAddedToCache(){
        dataCache.updateCache(key1, values1);
        ArrayList<V>  results = dataCache.search(key1);
        assertEquals(values1, results);
    }

    @Test
    void testCacheUpdatesItselfWhenValueIsNotInCache() {
        //setup
        when(mockDatabase.search(key1)).thenReturn(values1);

        assertEquals(values1, dataCache.search(key1));
    }

    @Test
    void testCacheAddNewItem(){
        dataCache.addNewItem(valA);

        verify(mockDatabase, times(1)).addNewItem(valA);
    }


    @Test
    void testCacheEvictsEntryWhenSizeIsReached() {
        dataCache.updateCache(key1, values1);
        dataCache.updateCache(key2, values2);
        dataCache.updateCache(key3, values3);

        // insert another key
        dataCache.updateCache(key4, values4);

        //check if key1 is evicted
        assertNotEquals(values1,dataCache.search(key1));
//
//        //check if key 4 is inserted
        assertEquals(values4,dataCache.search(key4));
    }

    @Test
    void testInvalidateKeys() {
        V diffVal1 = (V) "diff1";
        V diffVal2 = (V) "diff2";
        // this should be unaffected after the invalidation
        ArrayList<V> differentValues = new ArrayList<>(Arrays.asList(diffVal1, diffVal2));

        dataCache.updateCache(key3, differentValues);
        dataCache.updateCache(key1,values1);
        dataCache.updateCache(key2,values2);

        // invalidate key1 and key2
        dataCache.invalidateKeys(valA);

        // affected keys will be removed
        assertEquals(emptyListOfVitems, dataCache.search(key1));
        assertEquals(emptyListOfVitems, dataCache.search(key2));
        // unaffected key will stay
        assertEquals(differentValues, dataCache.search(key3));
    }

}