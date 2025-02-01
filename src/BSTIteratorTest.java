import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class TN extends BSTIterator.TreeNode {
    public TN(int i) {
        super(i);
    }

    public TN(int i, TN left, TN right) {
        super(i, left, right);
    }
}

class BSTIteratorTest {

    @Test
    void nextBothOrNoChildren() {
        TN A2 = new TN(9);
        TN A3 = new TN(20);
        TN A0 = new TN(3);
        TN A1 = new TN(15, A2, A3);
        TN root = new TN(7, A0, A1);

        BSTIterator iterator = new BSTIterator(root);
        int[] res = {3, 7, 9, 15, 20};
        for(int r: res) {
            assertTrue(iterator.hasNext());
            assertEquals(r, iterator.next());
        }

        assertFalse(iterator.hasNext());
        assertThrows(IllegalArgumentException.class, iterator::next);
    }

    @Test
    void nextRightNoLeft() {
        TN A2 = new TN(9);
        TN A3 = new TN(20);
        TN A4 = new TN(4);
        TN A5 = new TN(6);
        TN A6 = new TN(5, A4, A5);
        TN A0 = new TN(3, null, A6);
        TN A1 = new TN(15, A2, A3);
        TN root = new TN(7, A0, A1);

        BSTIterator iterator = new BSTIterator(root);
        int[] res = {3, 4, 5, 6, 7, 9, 15, 20};
        for(int r: res) {
            assertTrue(iterator.hasNext());
            assertEquals(r, iterator.next());
        }

        assertFalse(iterator.hasNext());
        assertThrows(IllegalArgumentException.class, iterator::next);
    }

    @Test
    void nextEmptyLeft() {
        TN A2 = new TN(9);
        TN A3 = new TN(20);
        TN A1 = new TN(15, A2, A3);
        TN root = new TN(7, null, A1);

        BSTIterator iterator = new BSTIterator(root);
        int[] res = {7, 9, 15, 20};
        for(int r: res) {
            assertTrue(iterator.hasNext());
            assertEquals(r, iterator.next());
        }

        assertFalse(iterator.hasNext());
        assertThrows(IllegalArgumentException.class, iterator::next);
    }

    @Test
    void nextEmptyRight() {
        TN A2 = new TN(4);
        TN A3 = new TN(6);
        TN A4 = new TN(5, A2, A3);
        TN A5 = new TN (3, null, A4);
        TN root = new TN(7, A5, null);

        BSTIterator iterator = new BSTIterator(root);
        int[] res = {3,4,5,6,7};
        for(int r: res) {
            assertTrue(iterator.hasNext());
            assertEquals(r, iterator.next());
        }

        assertFalse(iterator.hasNext());
        assertThrows(IllegalArgumentException.class, iterator::next);
    }


}