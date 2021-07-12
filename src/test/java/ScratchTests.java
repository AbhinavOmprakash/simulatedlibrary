import library.models.contributors.Author;
import library.models.contributors.Contributor;
import library.models.libraryitems.Book;
import library.models.libraryitems.LibraryItem;
import org.junit.jupiter.api.Test;
import setup.ObjectFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ScratchTests {
    private class Temp {
        public void getSome(){
            System.out.println("this is a string");
        }
        public void getALotMore(){
            System.out.println("greed is bad");
        }
    }

    @Test
    void testClassObjectNotation() {
        Temp temp = new Temp();
        assertEquals(temp.getClass(), Temp.class);
    }

    @Test
    void checkInstanceOfTemp(){
        Temp temp = new Temp();
        assertTrue(temp.getClass() instanceof Object);
    }
    @Test
    void getMethods() throws InvocationTargetException, IllegalAccessException {
        Temp temp = new Temp();
        Object[] methods =temp.getClass().getMethods();
        System.out.println(methods[0]);
        System.out.println(methods[1]);
        System.out.println(methods[1].getClass());

        Method some = (Method) methods[0];
        some.invoke(temp);
    }

    @Test
    void testLocalDateTime() {
        LocalDateTime borrowedOn = LocalDateTime.of(2021,2,1,1,10);
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime overDue =  today.minusDays(30);
        assertTrue(borrowedOn.isBefore(overDue));
    }

    @Test
    void testContributor(){
        Contributor contributor1 = new Author("deepak");
        Contributor contributor2 = new Author("john");
        ArrayList<Contributor> contributors = new ArrayList<>(Arrays.asList(contributor1, contributor2));
//
        assertEquals(contributor1.toString(),"deepak");
        assertEquals(contributor2.toString(),"john");
        System.out.println(contributors.toString());
    }
    @Test
    void testLibItem(){
        LibraryItem book = ObjectFactory.getTheFaultInOurStars();
        System.out.println(Arrays.toString(book.getSearchableString()));
//        System.out.println(book.getContributors());
    }


}
