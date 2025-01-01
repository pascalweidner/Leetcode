import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeTwoSortedListsTest {
    MergeTwoSortedLists m;

    @BeforeEach
    void setUp() {
        m = new MergeTwoSortedLists();
    }

    @Test
    void mergeTwoListsSameLength3() {
        MergeTwoSortedLists.ListNode n3 = new MergeTwoSortedLists.ListNode(4);
        MergeTwoSortedLists.ListNode n2 = new MergeTwoSortedLists.ListNode(2, n3);
        MergeTwoSortedLists.ListNode n1 = new MergeTwoSortedLists.ListNode(1, n2);

        MergeTwoSortedLists.ListNode n6 = new MergeTwoSortedLists.ListNode(4);
        MergeTwoSortedLists.ListNode n5 = new MergeTwoSortedLists.ListNode(3, n6);
        MergeTwoSortedLists.ListNode n4 = new MergeTwoSortedLists.ListNode(1, n5);

        MergeTwoSortedLists.ListNode curr = m.mergeTwoLists(n1, n4);
        int[] vals = {1,1,2,3,4,4};
        int i = 0;
        while (curr != null) {
            assertEquals(vals[i++], curr.val);
            curr = curr.next;
        }
        assertEquals(vals.length, i);
    }

    @Test
    void mergeTwoListsEmptyLists() {

        MergeTwoSortedLists.ListNode curr = m.mergeTwoLists(null, null);
        int[] vals = {};
        int i = 0;
        while (curr != null) {
            assertEquals(vals[i++], curr.val);
            curr = curr.next;
        }
        assertEquals(vals.length, i);
    }

    @Test
    void mergeTwoListsOneEmpty() {
        MergeTwoSortedLists.ListNode n1 = new MergeTwoSortedLists.ListNode(0);

        MergeTwoSortedLists.ListNode curr = m.mergeTwoLists(null, n1);
        int[] vals = {0};
        int i = 0;
        while (curr != null) {
            assertEquals(vals[i++], curr.val);
            curr = curr.next;
        }
        assertEquals(vals.length, i);
    }

     @Test
    void mergeTwoListsNegativeValues() {
        MergeTwoSortedLists.ListNode n3 = new MergeTwoSortedLists.ListNode(-5);
        MergeTwoSortedLists.ListNode n2 = new MergeTwoSortedLists.ListNode(-8, n3);
        MergeTwoSortedLists.ListNode n1 = new MergeTwoSortedLists.ListNode(-10, n2);

        MergeTwoSortedLists.ListNode n6 = new MergeTwoSortedLists.ListNode(4);
        MergeTwoSortedLists.ListNode n5 = new MergeTwoSortedLists.ListNode(3, n6);
        MergeTwoSortedLists.ListNode n4 = new MergeTwoSortedLists.ListNode(1, n5);

        MergeTwoSortedLists.ListNode curr = m.mergeTwoLists(n1, n4);
        int[] vals = {-10, -8, -5, 1, 3, 4};
        int i = 0;
        while (curr != null) {
            assertEquals(vals[i++], curr.val);
            curr = curr.next;
        }
        assertEquals(vals.length, i);
    }

    @Test
    void mergeTwoListsSecondEmpty() {
        MergeTwoSortedLists.ListNode n1 = new MergeTwoSortedLists.ListNode(0);

        MergeTwoSortedLists.ListNode curr = m.mergeTwoLists(n1, null);
        int[] vals = {0};
        int i = 0;
        while (curr != null) {
            assertEquals(vals[i++], curr.val);
            curr = curr.next;
        }
        assertEquals(vals.length, i);
    }

    @Test
    void mergeTwoListsDifferentLength() {
        MergeTwoSortedLists.ListNode n4 = new MergeTwoSortedLists.ListNode(5);
        MergeTwoSortedLists.ListNode n3 = new MergeTwoSortedLists.ListNode(-5, n4);
        MergeTwoSortedLists.ListNode n2 = new MergeTwoSortedLists.ListNode(-8, n3);
        MergeTwoSortedLists.ListNode n1 = new MergeTwoSortedLists.ListNode(-10, n2);

        MergeTwoSortedLists.ListNode n7 = new MergeTwoSortedLists.ListNode(4);
        MergeTwoSortedLists.ListNode n6 = new MergeTwoSortedLists.ListNode(3, n7);
        MergeTwoSortedLists.ListNode n5 = new MergeTwoSortedLists.ListNode(1, n6);

        MergeTwoSortedLists.ListNode curr = m.mergeTwoLists(n1, n5);
        int[] vals = {-10, -8, -5, 1, 3, 4, 5};
        int i = 0;
        while (curr != null) {
            assertEquals(vals[i++], curr.val);
            curr = curr.next;
        }
        assertEquals(vals.length, i);
    }
}