package leetcode;

/**
 * Created by jiaxing on 17-3-15.
 */

/**
 * Reverse Linked List 2
 */
public class M92 {

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m - n >= 0)
            return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode cur = head, p = dummy;
        int count = 1;
        while (count < m){
            count++;
            p = p.next;
            cur = cur.next;
        }

        while (count < n){
            ListNode tmp = cur.next;
            cur.next = tmp.next;
            tmp.next = p.next;
            p.next = tmp;

            count++;

        }

        return dummy.next;
    }

}
