import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RLEIteratorTest {

    @Test
    void nextSimpleEncodingFirst3CharsAllSame() {
        int[] encoding = {3,8,2,5};
        RLEIterator iterator = new RLEIterator(encoding);
        assertEquals(8, iterator.next(3));
    }

    @Test
    void nextSimpleEncodingDifferentCharsInOneGo() {
        int[] encoding = {3,8,2,5};
        RLEIterator iterator = new RLEIterator(encoding);
        assertEquals(5, iterator.next(4));
    }

    @Test
    void nextSimpleEncodingAllInOneGo() {
        int[] encoding = {3,8,2,5};
        RLEIterator iterator = new RLEIterator(encoding);
        assertEquals(5, iterator.next(5));
    }

    @Test
    void nextSimpleEncodingMoreThanAllowedInOneGo() {
        int[] encoding = {3,8,2,5};
        RLEIterator iterator = new RLEIterator(encoding);
        assertEquals(-1, iterator.next(6));
    }

    @Test
    void nextSimpleEncodingMoreThanAllowedInOneGo2() {
        int[] encoding = {3,8,2,5};
        RLEIterator iterator = new RLEIterator(encoding);
        assertEquals(-1, iterator.next(20));
    }

    @Test
    void nextSimpleEncodingInMultipleSteps() {
        int[] encoding = {3,8,2,5};
        RLEIterator iterator = new RLEIterator(encoding);
        assertEquals(8, iterator.next(2));
        assertEquals(8, iterator.next(1));
    }

    @Test
    void nextSimpleEncodingInMultipleSteps2() {
        int[] encoding = {3,8,2,5};
        RLEIterator iterator = new RLEIterator(encoding);
        assertEquals(8, iterator.next(2));
        assertEquals(5, iterator.next(2));
    }

    @Test
    void nextSimpleEncodingInMultipleStepsInNotAllowed() {
        int[] encoding = {3,8,2,5};
        RLEIterator iterator = new RLEIterator(encoding);
        assertEquals(8, iterator.next(2));
        assertEquals(8, iterator.next(1));
        assertEquals(5, iterator.next(1));
        assertEquals(-1, iterator.next(2));
    }

    @Test
    void nextSimpleEncodingInMultipleStepsALotOfNotAllowed() {
        int[] encoding = {3,8,2,5};
        RLEIterator iterator = new RLEIterator(encoding);
        assertEquals(5, iterator.next(5));
        assertEquals(-1, iterator.next(2));
        assertEquals(-1, iterator.next(1));
        assertEquals(-1, iterator.next(1));
        assertEquals(-1, iterator.next(2));
    }

    @Test
    void nextSimpleEncoding0Beginning() {
        int[] encoding = {0, 8, 3, 7};
        RLEIterator iterator = new RLEIterator(encoding);
        assertEquals(7, iterator.next(3));
        assertEquals(-1, iterator.next(3));
    }

    @Test
    void nextSimpleEncoding0End() {
        int[] encoding = {3, 7, 0, 8};
        RLEIterator iterator = new RLEIterator(encoding);
        assertEquals(7, iterator.next(3));
        assertEquals(-1, iterator.next(3));
    }

    @Test
    void nextSimpleEncodingOnly0() {
        int[] encoding = {0, 7, 0, 8, 0, 3};
        RLEIterator iterator = new RLEIterator(encoding);
        assertEquals(-1, iterator.next(3));
        assertEquals(-1, iterator.next(3));
    }

    @Test
    void nextSimpleEncodingN0() {
        int[] encoding = {3,8, 0,9, 2,5};
        RLEIterator iterator = new RLEIterator(encoding);
        assertEquals(-1, iterator.next(0));
        assertEquals(8, iterator.next(3));
    }

    @Test
    void nextSimpleEncodingVeryLargeEncoding() {
        int[] encoding = {784,303,477,583,909,505};
        RLEIterator iterator = new RLEIterator(encoding);
        assertEquals(303, iterator.next(130));
        assertEquals(303, iterator.next(333));
        assertEquals(303, iterator.next(238));
        assertEquals(583, iterator.next(87));
        assertEquals(583, iterator.next(301));
        assertEquals(505, iterator.next(276));
    }

}