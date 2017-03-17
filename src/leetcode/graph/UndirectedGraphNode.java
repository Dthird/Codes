package leetcode.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jason on 3/17/17.
 */
public class UndirectedGraphNode {
    public int label;
    public List<UndirectedGraphNode> neighbors;

    UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
};
