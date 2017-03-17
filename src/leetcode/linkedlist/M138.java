package leetcode.linkedlist;

/**
 * Created by jason on 3/17/17.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Copy List with Random Pointer
 */
public class M138 {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null)
            return null;

        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();

        RandomListNode p = head;
        while (p != null){
            map.put(p, new RandomListNode(p.label));
            p = p.next;
        }

        for (Map.Entry<RandomListNode, RandomListNode> entry : map.entrySet()) {
            RandomListNode tmp = entry.getValue();
            tmp.next = map.get(entry.getKey().next);
            tmp.random = map.get(entry.getKey().random);
        }
        return map.get(head);
    }

}
