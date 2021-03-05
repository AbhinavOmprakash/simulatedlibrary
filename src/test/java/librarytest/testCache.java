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
    public void testCacheSearch(){
        dataCache.insert(key1, values1);
        ArrayList<V>  results= dataCache.search(key1);
        assertEquals(values1, results);
    }



}