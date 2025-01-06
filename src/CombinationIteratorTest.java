import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CombinationIteratorTest {

    @Test
    void nextFirstCombinationSimple() {
        CombinationIterator iter = new CombinationIterator("abc", 2);
        assertEquals("ab", iter.next());
    }

    @Test
    void nextMultipleSimple() {
        CombinationIterator iter = new CombinationIterator("abc", 2);
        assertEquals("ab", iter.next());
        assertEquals("ac", iter.next());
        assertEquals("bc", iter.next());
    }


    @Test
    void hasNextFirstSimple() {
        CombinationIterator iter = new CombinationIterator("abc", 2);
        assertTrue(iter.hasNext());
    }

    @Test
    void hasNextEndSimple() {
        CombinationIterator iter = new CombinationIterator("abc", 2);
        iter.next();
        iter.next();
        assertTrue(iter.hasNext());
        iter.next();
        assertFalse(iter.hasNext());
    }

    @Test
    void combinations() {
        CombinationIterator iter = new CombinationIterator("abc", 2);
        assertEquals("ab", iter.next());
        assertTrue(iter.hasNext());
        assertEquals("ac", iter.next());
        assertTrue(iter.hasNext());
        assertEquals("bc", iter.next());
        assertFalse(iter.hasNext());
    }

    @Test
    void combinations1Comb() {
        CombinationIterator iter = new CombinationIterator("chp", 1);
        assertTrue(iter.hasNext());
        assertEquals("c", iter.next());
        assertTrue(iter.hasNext());
        assertTrue(iter.hasNext());
        assertEquals("h", iter.next());
        assertEquals("p", iter.next());
        assertFalse(iter.hasNext());
        assertFalse(iter.hasNext());
        assertFalse(iter.hasNext());
        assertFalse(iter.hasNext());
    }
}