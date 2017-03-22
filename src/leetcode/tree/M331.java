package leetcode.tree;

/**
 * Created by jason on 3/22/17.
 */

import java.util.Stack;

/**
 * Verify Preorder Serialization of a Binary Tree
 */
public class M331 {
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int diff = 1;
        for (String node: nodes) {
            if (--diff < 0) return false;
            if (!node.equals("#")) diff += 2;
        }
        return diff == 0;
    }
    // stack
    public boolean isValidSerialization1(String preorder) {
        if (preorder.length() == 0)
            return true;
        Stack<String> stack = new Stack<>();
        String[] ts = preorder.split(",");
        for (String s: ts){
            if (s.equals("#")){
                if (stack.size() < 1)
                    return false;
                String tmp = stack.peek();
                if (tmp.equals("#")){
                    if (stack.size() < 2)
                        return false;
                    else {
                        stack.pop();
                        stack.pop();
                        stack.push(s);
                    }
                } else {
                    stack.push(s);
                }
            } else {
                stack.push(s);
            }
        }

        while(stack.peek().equals("#") && stack.size() > 1){
            String top0 = stack.pop();
            String top1 = stack.pop();
            if (!top0.equals(top1))
                return false;
            stack.pop();
            stack.push("#");
        }

        return stack.peek().equals("#");
    }
}
