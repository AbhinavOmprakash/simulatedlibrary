package librarytest;

import backend.library.DataManager;
import backend.externalservices.DataStoreInterface;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class testDataManager<K,V> {

    private DataManager<K, V> manager;
    private K query;

    @Mock
    DataStoreInterface<K,V> dataStore;

    @Mock
    DataStoreInterface<K,V> newDataStore;


    @BeforeEach
    public void setUp() {
        manager = new DataManager<>(dataStore);

        query = (K) ("famous five go to kirrin island");
    }

    @Test
    public void TestSearch() {
        manager.search(query);
        verify(dataStore, times(1)).search(query);
    }

    @Test
    public void TestUpdate() {
        // test specific setup
        V item = (V) ("updated item");
        manager.updateData(item);
        verify(dataStore, times(1)).updateItem(item);

    }

    @Test
    public void TestSetDataStory(){
        DataStoreInterface<K,V> oldDataStore = manager.getDataStore();
        manager.setDataStore(newDataStore);
        assertNotEquals(oldDataStore, newDataStore);

    }
}
