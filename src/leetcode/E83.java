package leetcode;

/**
 * Created by jason on 3/14/17.
 */

/**
 * Remove Duplicates from Sorted List
 */
public class E83 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode p = head, q = head.next;
        while (q!= null){
            if (q.val == p.val){
                q = q.next;
                p.next = q;
            } else {
                p.next = q;
                q = q.next;
                p = p.next;
            }

        }

        return head;
    }
}
