package leetcode;

/**
 * Created by jason on 3/8/17.
 */
public class M19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode listNode = new ListNode(-1);
        listNode.next = head;
        ListNode p = listNode, q = listNode;

        while (n >= 0){
            p = p.next;
            n--;
        }
        while ( p != null){
            p = p.next;
            q = q.next;
        }

        q.next = q.next.next;
        return listNode.next;
    }
}
