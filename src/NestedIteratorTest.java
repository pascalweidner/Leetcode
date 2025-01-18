import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class NestedIteratorTest {
    public static class NestedIntegerInt implements NestedIterator.NestedInteger {
        private final Integer i;

        public NestedIntegerInt(int i) {
            this.i = i;
        }

        @Override
        public boolean isInteger() {
            return true;
        }

        @Override
        public Integer getInteger() {
            return i;
        }

        @Override
        public List<NestedIterator.NestedInteger> getList() {
            return null;
        }
    }

    public static class NestedIntegerList implements NestedIterator.NestedInteger {
        private final List<NestedIterator.NestedInteger> list;

        public NestedIntegerList(List<NestedIterator.NestedInteger> list) {
            this.list = list;
        }

        @Override
        public boolean isInteger() {
            return false;
        }

        @Override
        public Integer getInteger() {
            return null;
        }

        @Override
        public List<NestedIterator.NestedInteger> getList() {
            return list;
        }
    }

    @Test
    void nextDepthOneMultipleNestedLists() {
        List<NestedIterator.NestedInteger> list = List.of(new NestedIntegerList(List.of(new NestedIntegerInt(1), new NestedIntegerInt(1))), new NestedIntegerInt(2),new NestedIntegerList(List.of(new NestedIntegerInt(1), new NestedIntegerInt(1))));
        NestedIterator it = new NestedIterator(list);
        System.out.println("test");
        int[] res = {1,1,2,1,1};
        for (int re : res) {
            assertTrue(it.hasNext());
            assertEquals(re, it.next());
        }
        assertFalse(it.hasNext());
        assertThrows(NoSuchElementException.class, it::next);
        assertThrows(NoSuchElementException.class, it::next);
    }

    @Test
    void nextDeepMultipleNestedListsBeginning() {
        List<NestedIterator.NestedInteger> list = List.of(new NestedIntegerList(List.of(new NestedIntegerList(List.of(new NestedIntegerList(List.of(new NestedIntegerList(List.of(new NestedIntegerList(List.of(new NestedIntegerList(List.of(new NestedIntegerInt(1), new NestedIntegerInt(1), new NestedIntegerInt(1))), new NestedIntegerInt(2))), new NestedIntegerInt(3))), new NestedIntegerInt(4))))), new NestedIntegerInt(5))));
        NestedIterator it = new NestedIterator(list);
        int[] res = {1,1,1,2,3,4,5};
        for(int re : res) {
            assertTrue(it.hasNext());
            assertEquals(re, it.next());
        }
        assertFalse(it.hasNext());
        assertThrows(NoSuchElementException.class, it::next);
    }

    @Test
    void nextDeepMultipleNestedListsEnd() {
        List<NestedIterator.NestedInteger> list = List.of(new NestedIntegerInt(1), new NestedIntegerList(List.of(new NestedIntegerInt(4), new NestedIntegerList(List.of(new NestedIntegerInt(6))))));
        NestedIterator it = new NestedIterator(list);
        int[] res = {1,4,6};
        for(int re : res) {
            assertTrue(it.hasNext());
            assertEquals(re, it.next());
        }
        assertFalse(it.hasNext());
        assertThrows(NoSuchElementException.class, it::next);
    }

    @Test
    void nextNoElements() {
        List<NestedIterator.NestedInteger> list = List.of();
        NestedIterator it = new NestedIterator(list);
        assertFalse(it.hasNext());
        assertThrows(NoSuchElementException.class, it::next);
    }

    @Test
    void nextEmptyNestedLists() {
        List<NestedIterator.NestedInteger> list = List.of(new NestedIntegerList(List.of()));
        NestedIterator it = new NestedIterator(list);
        assertFalse(it.hasNext());
        assertThrows(NoSuchElementException.class, it::next);
    }

    @Test
    void nextEmptyNestedListsInFullList() {
        List<NestedIterator.NestedInteger> list = List.of(new NestedIntegerInt(5), new NestedIntegerList(List.of()), new NestedIntegerInt(3));
        NestedIterator it = new NestedIterator(list);
        int[] res = {5,3};
        for(int re : res) {
            assertTrue(it.hasNext());
            assertEquals(re, it.next());
        }
        assertFalse(it.hasNext());
        assertThrows(NoSuchElementException.class, it::next);
    }

    @Test
    void nextEmptyNestedListsMultipleInFullList() {
        List<NestedIterator.NestedInteger> list = List.of(new NestedIntegerInt(5), new NestedIntegerList(List.of(new NestedIntegerList(List.of()))), new NestedIntegerInt(3));
        NestedIterator it = new NestedIterator(list);
        int[] res = {5,3};
        for(int re : res) {
            assertTrue(it.hasNext());
            assertEquals(re, it.next());
        }
        assertFalse(it.hasNext());
        assertThrows(NoSuchElementException.class, it::next);
    }

    @Test
    void nextEmptyNestedListMultipleNestedLists() {
        List<NestedIterator.NestedInteger> list = List.of(new NestedIntegerInt(1), new NestedIntegerList(List.of(new NestedIntegerList(List.of()), new NestedIntegerList(List.of(new NestedIntegerList(List.of()), new NestedIntegerInt(3))), new NestedIntegerInt(4))), new NestedIntegerList(List.of()));
        NestedIterator it = new NestedIterator(list);
        int[] res = {1,3,4};
        for(int re : res) {
            assertTrue(it.hasNext());
            assertEquals(re, it.next());
        }

        assertFalse(it.hasNext());
        assertThrows(NoSuchElementException.class, it::next);
    }

    @Test
    void nextOnlyEmptyNestedLists() {
        List<NestedIterator.NestedInteger> list = List.of(new NestedIntegerList(List.of(new NestedIntegerList(List.of(new NestedIntegerList(List.of()), new NestedIntegerList(List.of()), new NestedIntegerList(List.of(new NestedIntegerList(List.of()))))))));
        NestedIterator it = new NestedIterator(list);
        assertFalse(it.hasNext());
        assertThrows(NoSuchElementException.class, it::next);
    }

}