package librarytest;

import backend.externalservices.MapUtilities;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class MapUtilitiesTest<K,V> {

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
    ArrayList<V> diffValues;

    HashMap<K, ArrayList<V>> mapData;

    @BeforeEach
    public void setUp() {
        mapData = new HashMap<>();

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
        diffValues = new ArrayList<>(Arrays.asList(valA, valB));

        mapData.put(key1, values1);
        mapData.put(key2, values2);
        mapData.put(key3, values3);
        mapData.put(key4, diffValues);

    }
    @Test
    void testGetAllKeysForValue() {
        ArrayList<K> results = MapUtilities.getAllKeysForValue(mapData, valC);
        ArrayList<K> expected = new ArrayList<>(Arrays.asList(key1, key2, key3));
        assertEquals(expected, results);
    }

}