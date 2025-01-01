import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddTwoNumbersTest {
    AddTwoNumbers a;

    @BeforeEach
    void setUp() {
        a = new AddTwoNumbers();
    }

    @Test
    void addTwoNumbersSameLength3() {
        AddTwoNumbers.ListNode n3 = new AddTwoNumbers.ListNode(3);
        AddTwoNumbers.ListNode n2 = new AddTwoNumbers.ListNode(4, n3);
        AddTwoNumbers.ListNode n1 = new AddTwoNumbers.ListNode(2, n2);

        AddTwoNumbers.ListNode n6 = new AddTwoNumbers.ListNode(4);
        AddTwoNumbers.ListNode n5 = new AddTwoNumbers.ListNode(6, n6);
        AddTwoNumbers.ListNode n4 = new AddTwoNumbers.ListNode(5, n5);

        AddTwoNumbers.ListNode curr = a.addTwoNumbers(n1, n4);
        int[] vals = {7, 0, 8};
        int i = 0;
        while (curr != null) {
            assertEquals(vals[i++], curr.val);
            curr = curr.next;
        }
        assertEquals(vals.length, i);
    }

    @Test
    void addTwoNumbersSameLength1() {
        AddTwoNumbers.ListNode n1 = new AddTwoNumbers.ListNode(0);

        AddTwoNumbers.ListNode n4 = new AddTwoNumbers.ListNode(0);

        AddTwoNumbers.ListNode curr = a.addTwoNumbers(n1, n4);
        int[] vals = {0};
        int i = 0;
        while (curr != null) {
            assertEquals(vals[i++], curr.val);
            curr = curr.next;
        }
        assertEquals(vals.length, i);
    }

    @Test
    void addTwoNumbersDifferentLength() {
        AddTwoNumbers.ListNode n7 = new AddTwoNumbers.ListNode(9);
        AddTwoNumbers.ListNode n6 = new AddTwoNumbers.ListNode(9, n7);
        AddTwoNumbers.ListNode n5 = new AddTwoNumbers.ListNode(9, n6);
        AddTwoNumbers.ListNode n4 = new AddTwoNumbers.ListNode(9, n5);
        AddTwoNumbers.ListNode n3 = new AddTwoNumbers.ListNode(9, n4);
        AddTwoNumbers.ListNode n2 = new AddTwoNumbers.ListNode(9, n3);
        AddTwoNumbers.ListNode n1 = new AddTwoNumbers.ListNode(9, n2);

        AddTwoNumbers.ListNode n11 = new AddTwoNumbers.ListNode(9);
        AddTwoNumbers.ListNode n10 = new AddTwoNumbers.ListNode(9, n11);
        AddTwoNumbers.ListNode n9 = new AddTwoNumbers.ListNode(9, n10);
        AddTwoNumbers.ListNode n8 = new AddTwoNumbers.ListNode(9, n9);

        AddTwoNumbers.ListNode curr = a.addTwoNumbers(n1, n8);
        int[] vals = {8,9,9,9,0,0,0,1};
        int i = 0;
        while (curr != null) {
            assertEquals(vals[i++], curr.val);
            curr = curr.next;
        }
        assertEquals(vals.length, i);
    }

    @Test
    void addTwoNumbersOneEmpty() {
        AddTwoNumbers.ListNode n7 = new AddTwoNumbers.ListNode(9);
        AddTwoNumbers.ListNode n6 = new AddTwoNumbers.ListNode(9, n7);
        AddTwoNumbers.ListNode n5 = new AddTwoNumbers.ListNode(9, n6);
        AddTwoNumbers.ListNode n4 = new AddTwoNumbers.ListNode(9, n5);
        AddTwoNumbers.ListNode n3 = new AddTwoNumbers.ListNode(9, n4);
        AddTwoNumbers.ListNode n2 = new AddTwoNumbers.ListNode(9, n3);
        AddTwoNumbers.ListNode n1 = new AddTwoNumbers.ListNode(9, n2);

        AddTwoNumbers.ListNode curr = a.addTwoNumbers(n1, null);
        int[] vals = {9,9,9,9,9,9,9};
        int i = 0;
        while (curr != null) {
            assertEquals(vals[i++], curr.val);
            curr = curr.next;
        }
        assertEquals(vals.length, i);
    }

    @Test
    void addTwoNumbersSecondEmpty() {
        AddTwoNumbers.ListNode n7 = new AddTwoNumbers.ListNode(9);
        AddTwoNumbers.ListNode n6 = new AddTwoNumbers.ListNode(9, n7);
        AddTwoNumbers.ListNode n5 = new AddTwoNumbers.ListNode(9, n6);
        AddTwoNumbers.ListNode n4 = new AddTwoNumbers.ListNode(9, n5);
        AddTwoNumbers.ListNode n3 = new AddTwoNumbers.ListNode(9, n4);
        AddTwoNumbers.ListNode n2 = new AddTwoNumbers.ListNode(9, n3);
        AddTwoNumbers.ListNode n1 = new AddTwoNumbers.ListNode(9, n2);

        AddTwoNumbers.ListNode curr = a.addTwoNumbers(null, n1);
        int[] vals = {9,9,9,9,9,9,9};
        int i = 0;
        while (curr != null) {
            assertEquals(vals[i++], curr.val);
            curr = curr.next;
        }
        assertEquals(vals.length, i);
    }

    @Test
    void addTwoNumbersBothEmpty() {

        AddTwoNumbers.ListNode curr = a.addTwoNumbers(null, null);
        int[] vals = {};
        int i = 0;
        while (curr != null) {
            assertEquals(vals[i++], curr.val);
            curr = curr.next;
        }
        assertEquals(vals.length, i);
    }
}