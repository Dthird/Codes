package leetcode;

/**
 * Created by jason on 3/8/17.
 */
public class M24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null){
            return head;
        }
        ListNode start = new ListNode(-1);
        start.next = head;
        ListNode prev = start, p = head, q = head.next;
        while (q != null){
            p.next = q.next;
            q.next = p;
            prev.next = q;
            prev = p;
            p = p.next;
            if (p != null && p.next != null) {
                q = p.next;
            } else{
                break;
            }
        }
        return start.next;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        M24 m24 = new M24();
        m24.swapPairs(head);

    }
}
