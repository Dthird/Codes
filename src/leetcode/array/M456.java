package leetcode.array;

/**
 * Created by jason on 3/29/17.
 */

import java.util.Stack;

/**
 * 132 Pattern
 */
public class M456 {
    public boolean find132pattern(int[] nums) {
        if (nums.length < 3)
            return false;
        Stack<M347.Pair> stack = new Stack<>();
        for (int num: nums){
            if (stack.isEmpty() || num < stack.peek().getFirst())
                stack.push(new M347.Pair(num, num));
            else if (num > stack.peek().getFirst()){
                M347.Pair tmp = stack.pop();
                if (tmp.getSecond() <= num){
                    tmp.setSecond(num);
                    while (!stack.isEmpty() && num >= stack.peek().getSecond()) // there is a trick, think more
                        stack.pop();
                    if (!stack.isEmpty() && num > stack.peek().getFirst())
                        return true;
                    stack.push(tmp);
                } else {
                    return true;
                }
            }
        }
        return false;
    }

}
