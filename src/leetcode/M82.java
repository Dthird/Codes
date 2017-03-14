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

        ListNode p = head, q = head.next;
        while (q != null){
            if (p.val == q.val){

            } else {

            }
        }
        return dummy.next;
    }
}
