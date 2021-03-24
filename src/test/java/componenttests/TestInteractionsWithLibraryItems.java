package componenttests;

import backend.controllers.DataManager;
import backend.controllers.LibraryItemManager;
import backend.externalservices.DataStoreInterface;
import backend.externalservices.HibernateDB;
import backend.dataobjects.libraryitems.Book;
import backend.dataobjects.libraryitems.LibraryItem;
import backend.dataobjects.libraryitems.contributors.Author;
import backend.dataobjects.libraryitems.contributors.Contributor;
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
