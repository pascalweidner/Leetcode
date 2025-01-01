
public class AddTwoNumbers {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, 0);
    }

    private ListNode addTwoNumbers(ListNode l1, ListNode l2, int overflow) {
        if(l1 == null && l2 == null) {
            if(overflow == 0) return null;
            return new ListNode(overflow, null);
        }
        if(l1 == null) {
            int result = l2.val + overflow;
            return new ListNode(result % 10, addTwoNumbers(null, l2.next, result / 10));
        }
        if(l2 == null) {
            int result = l1.val + overflow;
            return new ListNode(result % 10, addTwoNumbers(l1.next, null, result / 10));
        }

        int result = l1.val + l2.val + overflow;
        return new ListNode(result % 10, addTwoNumbers(l1.next, l2.next, result / 10));
    }
}
