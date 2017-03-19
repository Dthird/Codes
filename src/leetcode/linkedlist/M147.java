package leetcode.linkedlist;

/**
 * Created by jason on 3/18/17.
 */

/**
 * Insertion Sort List
 */
public class M147 {

    public ListNode insertionSortList(ListNode head) {
        /*if (head == null || head.next == null)
            return head;
            */

        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;

        ListNode cur = head, prev = dummy;
        while (cur != null){
            ListNode p = dummy.next, pPrev = dummy; // cannot assign head to p
            while (p != cur && p.val <= cur.val){
                p = p.next;
                pPrev = pPrev.next;
            }
            if (p != cur){
                prev.next = cur.next;
                cur.next = p;
                pPrev.next = cur;
                cur = prev.next;
            } else {
                cur = cur.next;
                prev = prev.next;
            }
        }
        return dummy.next;
    }
}
