package leetcode;

/**
 * Created by jason on 3/15/17.
 */

/**
 * Partition List
 */
public class M86 {

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;

        ListNode p = dummy, cur = head, prev = dummy;
        while (cur != null){
            if (cur.val < x){
                if (prev.val < x){
                    cur = cur.next;
                    prev = prev.next;
                    p = p.next;
                } else {
                    prev.next = cur.next;
                    cur.next = p.next;
                    p.next = cur;
                    cur = prev.next;
                    p = p.next;
                }
            } else {
                cur = cur.next;
                prev = prev.next;
            }
        }
        return dummy.next;
    }
}
