package library;

import library.models.LibraryUtils;
import library.models.libraryitems.Book;
import library.models.libraryitems.LibraryItem;
import library.models.contributors.Author;
import library.models.contributors.Contributor;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestLibItemDataFormatter {
    Contributor writer1 = new Author("John Green");
    Contributor writer2 = new Author("David Levithan");
    ArrayList<Contributor> contributors = new ArrayList<>(Arrays.asList(writer1, writer2));

    LibraryItem book = new Book("Will Greyson,Will Greyson",
            "YA",
            123456789,
            true,
            999999999);


    @Test
    void testGetFormattedTitle() {
        book.setContributors(contributors);
        assertEquals(book.getTitle(), LibraryUtils.getFormattedTitle(book));
    }

    @Test
    void testGetFormattedContributors() {
        String separator = "     ";
        String expected = "By - Author : John Green" +
                "\n" + separator + "Author : David Levithan" +
                "\n" + separator;

        assertEquals(expected, LibraryUtils.getFormattedContributors(book));
    }

}
