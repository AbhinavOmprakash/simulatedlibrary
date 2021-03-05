package librarytest;

import library.Cache;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class testCache<K, V> {
    private Cache<K,V> dataCache;

    K key1;
    K key2;
    K key3;
    K key4;
     
    V valA;
    V valB;
    V valC;
    ArrayList<V> values1;
    ArrayList<V> values2;
    ArrayList<V> values3;
    ArrayList<V> values4;

    @BeforeEach
    public void setUp() {
        dataCache = new Cache<>(3);

        key1 = (K) ("key1");
        key2 = (K) ("key2");
        key3 = (K) ("key3");
        key4 = (K) ("key4");

        valA = (V) ("val A");
        valB = (V) ("val B");
        valC = (V) ("val C");

        values1 = new ArrayList<>(Arrays.asList(valA, valB, valC));
        values2 = new ArrayList<>(Arrays.asList(valA, valB, valC));
        values3 = new ArrayList<>(Arrays.asList(valA, valB, valC));
        values4 = new ArrayList<>(Arrays.asList(valA, valB, valC));

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
    public void testCacheInsertAndSearch(){
        dataCache.insert(key1, values1);
        ArrayList<V>  results= dataCache.search(key1);
        assertEquals(values1, results);
    }

    @Test
    void testCacheSearchWhenDataNotInCache() {
        ArrayList<V> expectedResults= new ArrayList<>();
        assertEquals(expectedResults, dataCache.search(key2));
    }

    @Test
    void testCacheEvictsEntryWhenSizeIsReached() {
        dataCache.insert(key1, values1);
        dataCache.insert(key2, values2);
        dataCache.insert(key3, values3);

        // insert another key
        dataCache.insert(key4, values4);

        //check if key1 is evicted
        assertNotEquals(values1,dataCache.search(key1));
//
//        //check if key 4 is inserted
        assertEquals(values4,dataCache.search(key4));
    }

    @Test
    void testInvalidateKeys() {
        dataCache.insert(key1,values1);
        dataCache.insert(key2,values2);

        V diffVal1 = (V) "diff1";
        V diffVal2 = (V) "diff2";
        // this should be unaffected after the invalidation
        ArrayList<V> differentValues = new ArrayList<>(Arrays.asList(diffVal1, diffVal2));

        dataCache.insert(key3, differentValues);

        ArrayList<K> expectedStaleKeys = new ArrayList<>(Arrays.asList(key1,key2));

        assertEquals(expectedStaleKeys, dataCache.invalidateKeys(valA));

        // affected keys will be removed
//        assertNotEquals(values1, dataCache.search(key1));
//        assertNotEquals(values2, dataCache.search(key2));
//        // unaffected key will stay
//        assertEquals(differentValues, dataCache.search(key3));
    }
}