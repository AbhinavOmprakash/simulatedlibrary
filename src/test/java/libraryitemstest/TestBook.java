package libraryitemstest;

import libraryitems.Book;
import libraryitems.LibraryItem;
import libraryitems.contributors.Contributor;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TestBook {

    protected String title = "the perks of Being a wallflower";
    protected String subject = "Young adult";
    protected int UPC = 123456789;

    @Mock
    protected ArrayList<Contributor> contributors;

    protected boolean isBorrowable = true;
    protected boolean isCheckedOut = false;
    private Book book;


    @BeforeEach
    public void setup() {
        book = new Book(title,
                subject, UPC, contributors, isBorrowable, 123456789);
    }

    @Test
    public void testBorrowItemWhenItemIsBorrowable(){
        LibraryItem item = null;
        try{
            item = book.borrowItem();
        } catch (UnsupportedOperationException ignored){}

        assertNotNull(item);
        assertEquals(book, item);
    }

    @Test
    void testBorrowItemWhenItemIsNotBorrowable() {
        book.setBorrowable(false);
        assertThrows(UnsupportedOperationException.class,
                () -> book.borrowItem());
    }

    @Test
    void testBorrowItemWhenItemIsCheckedOut(){
        book.checkOut();
        assertThrows(UnsupportedOperationException.class,
                () -> book.borrowItem());
    }

}
