package leetcode;

/**
 * Created by jason on 3/14/17.
 */

/**
 * Remove Duplicates from Sorted List 2
 */
public class M82 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode p = dummy, q = head;
        while (q != null){
            while (q.next != null && q.val == q.next.val){
                q = q.next;
            }

            if (q == p.next){
                p = q;
            } else {
                p.next = q.next;
            }
            q = q.next;
        }
        return dummy.next;
    }
}
