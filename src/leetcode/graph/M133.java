package leetcode.graph;

/**
 * Created by jason on 3/17/17.
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Clone Graph
 */
public class M133 {

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null)
            return null;
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()){
            UndirectedGraphNode tmp = queue.poll();
            if (!map.containsKey(tmp)){
                map.put(tmp, new UndirectedGraphNode(tmp.label));
            }

            for (UndirectedGraphNode nei : tmp.neighbors) {
                if (!map.containsKey(nei)){
                    map.put(nei, new UndirectedGraphNode(nei.label));
                    queue.offer(nei);
                }
                map.get(tmp).neighbors.add(map.get(nei));

            }

        }
        return map.get(node);
    }
}
