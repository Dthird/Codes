package leetcode.linkedlist;

/**
 * Created by jason on 3/17/17.
 */

/**
 * Linked List Cycle
 */
public class E141 {

    public boolean hasCycle(ListNode head) {
        ListNode p = head;
        while (p != null) {
            if (p.val == Integer.MAX_VALUE)
                return true;
            p.val = Integer.MAX_VALUE;
            p = p.next;
        }
        return false;
    }
}
