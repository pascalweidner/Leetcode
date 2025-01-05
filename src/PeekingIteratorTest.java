import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PeekingIteratorTest {
    PeekingIterator iterator;

    @Test
    void peek123() {
        PeekingIterator iter = new PeekingIterator(List.of(1 , 2, 3).iterator());
        assertEquals(1, iter.peek());
    }

    @Test
    void peekAfterNext() {
        PeekingIterator iter = new PeekingIterator(List.of(1 , 2, 3).iterator());
        iter.next();
        assertEquals(2, iter.peek());
    }

    @Test
    void peekBeforeAndAfterNext() {
        PeekingIterator iter = new PeekingIterator(List.of(1 , 2, 3).iterator());
        assertEquals(1, iter.peek());
        iter.next();
        assertEquals(2, iter.peek());
    }

    @Test
    void next123First() {
        PeekingIterator iter = new PeekingIterator(List.of(1 , 2, 3).iterator());
        assertEquals(1, iter.next());
        assertEquals(2, iter.peek());
    }

    @Test
    void peekLast() {
        PeekingIterator iter = new PeekingIterator(List.of(1 , 2, 3).iterator());
        iter.next();
        iter.next();
        assertEquals(3, iter.peek());
    }

    @Test
    void peekForbidden() {
        PeekingIterator iter = new PeekingIterator(List.of(1 , 2, 3).iterator());
        iter.next();
        iter.next();
        iter.next();
        assertNull(iter.peek());
    }

    @Test
    void nextForbidden() {
        PeekingIterator iter = new PeekingIterator(List.of(1 , 2, 3).iterator());
        iter.next();
        iter.next();
        iter.next();
        assertNull(iter.next());
    }

    @Test
    void hasNext123First() {
        PeekingIterator iter = new PeekingIterator(List.of(1 , 2, 3).iterator());
        assertTrue(iter.hasNext());
    }

    @Test
    void hasNext123Middle() {
        PeekingIterator iter = new PeekingIterator(List.of(1 , 2, 3).iterator());
        iter.next();
        assertTrue(iter.hasNext());
    }

    @Test
    void hasNextEnd() {
        PeekingIterator iter = new PeekingIterator(List.of(1 , 2, 3).iterator());
        iter.next();
        iter.next();
        iter.next();
        assertFalse(iter.hasNext());
    }

    @Test
    void nextAfterPeek() {
        PeekingIterator iter = new PeekingIterator(List.of(1 , 2, 3).iterator());
        assertEquals(1, iter.next());
        assertEquals(2, iter.peek());
        assertEquals(2, iter.next());
    }

    @Test
    void sequence() {
        PeekingIterator iter = new PeekingIterator(List.of(1 , 2, 3).iterator());
        assertEquals(1, iter.next());
        assertEquals(2, iter.peek());
        assertEquals(2, iter.next());
        assertEquals(3, iter.next());
        assertFalse(iter.hasNext());
    }

}