package componenttests;

import common.models.DataManager;
import library.models.LibraryItemManager;
import common.models.DataStoreInterface;
import common.models.HibernateDB;
import library.models.libraryitems.Book;
import library.models.libraryitems.LibraryItem;
import library.models.contributors.Author;
import library.models.contributors.Contributor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SuppressWarnings({"unchecked", "rawtypes"})
public class TestInteractionsWithLibraryItems<V> {
    DataStoreInterface hibernateDB = HibernateDB.getTestInstance();
    DataManager libraryItemController = new LibraryItemManager();

    Contributor author;
    LibraryItem book;
    
    @BeforeEach
    void setUp() {
        author = new Author("Stephen Chbosky");
        hibernateDB.addNewItem((V) author);
        
        ArrayList<Contributor> contributors = new ArrayList<>(Collections.singletonList(author));
                
        book = new Book("Perks of Being a WallFlower","YA",100000000,contributors, true, 123456789);
        libraryItemController.addItem((V) book);
    }

    @AfterEach
    void tearDown() {
        hibernateDB.deleteItem((V) book);
        hibernateDB.deleteItem((V) author);
    }

    @Test
    void testItemCanBeModified() {
        String newSubject ="young adult";

        book.setSubject(newSubject);
        libraryItemController.updateData((V) book);

        ArrayList<V> results = libraryItemController.search(book.getTitle());

        LibraryItem searchedBook = (LibraryItem) results.get(0);

        assertEquals(newSubject,searchedBook.getSubject());


    }
}
