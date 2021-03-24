import backend.dataobjects.libraryitems.Book;
import backend.dataobjects.libraryitems.LibraryItem;
import backend.dataobjects.libraryitems.contributors.Author;
import backend.dataobjects.libraryitems.contributors.Contributor;
import org.junit.jupiter.api.Test;
import ui.library.LibItemDataFormatter;

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
            contributors,
            true,
            999999999);

    @Test
    void testGetFormattedTitle() {
        assertEquals(book.getTitle(), LibItemDataFormatter.getFormattedTitle(book));

    }

    @Test
    void testGetFormattedContributors() {
        String separator = "     ";
        String expected = "By - Author : John Green" +
                "\n" + separator + "Author : David Levithan" +
                "\n" + separator;

        assertEquals(expected, LibItemDataFormatter.getFormattedContributors(book));
    }

}
