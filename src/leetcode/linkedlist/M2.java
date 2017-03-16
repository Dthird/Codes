package leetcode.linkedlist;

/**
 * Created by jason on 3/6/17.
 */


/**
 * Add Two Numbers
 */
public class M2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode res = new ListNode(-1);
        ListNode p = res;
        ListNode tmp = null;
        while (l1 != null || l2 != null){
            if (l1 != null && l2 != null){
                carry += l1.val + l2.val;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 == null && l2 != null){
                carry += l2.val;
                l2 = l2.next;
            } else { //l1 != null && l2 == null
                carry += l1.val;
                l1 = l1.next;
            }
            tmp = new ListNode(carry % 10);
            p.next = tmp;
            carry /= 10;
            p = p.next;
        }
        // notice the carry
        if (carry != 0){
            p.next = new ListNode(carry);
        }
        return res.next;
    }

    public static void main(String[] args){
        M2 solution = new M2();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(8);
        ListNode l2 = new ListNode(0);
        ListNode res = solution.addTwoNumbers(l1, l2);
        while (res != null){
            System.out.print(res.val + " ");
            res = res.next;
        }
    }
}
