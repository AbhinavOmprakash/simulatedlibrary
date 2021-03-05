package librarytest;

import library.DataManager;
import library.DatabaseInterface;
import library.Cache;
import library.CacheInterface;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


@ExtendWith(MockitoExtension.class)
public class testDataManager<K,V> {

    private DataManager<K, V> manager;
    private String query;
    private V cacheResult;
    private V dbResult;

    @Mock
    DatabaseInterface<K,V> mockDatabase;

    @Mock
    CacheInterface<K, V> mockCache;

    @BeforeEach
    public void setUp() {
        manager = new DataManager<>(mockDatabase, mockCache);

        query = "famous five go to kirrin island";
        cacheResult = (V) ("CACHE result famous five go to kirrin island.");
        dbResult = (V) ("DB result famous five go to kirrin island.");
    }

    @Test
    public void TestSearchWhenDataInCacheAndDatabase() {

        ArrayList<V> expectedCacheResult = new ArrayList<>(Arrays.asList(cacheResult));

        when(mockCache.search(query)).thenReturn(expectedCacheResult);

        assertEquals(expectedCacheResult, manager.search(query));
    }

    @Test
    public void TestSearchWhenDataIsNotInCache() {

        ArrayList<V> expectedCacheResult = new ArrayList<>(Arrays.asList());
        ArrayList<V> expectedDBResult = new ArrayList<>(Arrays.asList(dbResult));

        when(mockDatabase.search(query)).thenReturn(expectedDBResult);
        when(mockCache.search(query)).thenReturn(expectedCacheResult);

        assertEquals(expectedDBResult, manager.search(query));

    }
    @Test
    public void TestSearchWhenDataIsNotPresentAtAll() {

        ArrayList<V> expectedCacheResult = new ArrayList<>(Arrays.asList());
        ArrayList<V> expectedDBResult = new ArrayList<>(Arrays.asList());

        when(mockDatabase.search(query)).thenReturn(expectedDBResult);
        when(mockCache.search(query)).thenReturn(expectedCacheResult);

        // assertNull(manager.search(query));
        assertEquals(expectedDBResult, manager.search(query));
    }

    @Test
    public void TestUpdate() {
        // test specific setup
        V item = (V) ("updated item");
        HashMap<K, ArrayList<V>> itemAttributes = new HashMap<K, ArrayList<V>>();

        V attr1 = (V)("attr1");
        V attr2= (V)("attr2");

        K itemTitle = (K) ("name");
        ArrayList<V> attributes = new ArrayList<>(Arrays.asList(attr1, attr2));
        itemAttributes.put(itemTitle, attributes);


        // DataManager calls getItem on the database during in update call.
        when(mockDatabase.getItem(item)).thenReturn(item);

        manager.updateData(item, itemAttributes);

        verify(mockDatabase, times(1)).update(item, itemAttributes);
        verify(mockCache, times(1)).invalidateKeys(item);

    }
}
