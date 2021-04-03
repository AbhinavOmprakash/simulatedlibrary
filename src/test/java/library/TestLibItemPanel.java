package library;

import common.models.Session;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestLibItemPanel {
    //bad test, I know
    //throwaway test

    boolean borrowButtonIsDisabled(boolean bookIsBorrowed,
                         boolean userCanBorrow){
        return bookIsBorrowed ||
                !userCanBorrow;
    }

    @Test
    void case1() {
        boolean bookIsBorrowed = false;
        boolean userCanBorrow = true;
        assertFalse(borrowButtonIsDisabled(bookIsBorrowed, userCanBorrow));
    }
    @Test
    void case2() {
        boolean bookIsBorrowed = true;
        boolean userCanBorrow = true;
        assertTrue(borrowButtonIsDisabled(bookIsBorrowed, userCanBorrow));
    }
    @Test
    void case3() {
        boolean bookIsBorrowed = true;
        boolean userCanBorrow = false;
        assertTrue(borrowButtonIsDisabled(bookIsBorrowed, userCanBorrow));
    }
    @Test
    void case4() {
        boolean bookIsBorrowed = false;
        boolean userCanBorrow = false;
        assertTrue(borrowButtonIsDisabled(bookIsBorrowed, userCanBorrow));
    }
}

