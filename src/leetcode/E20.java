package leetcode;

import java.util.Stack;

/**
 * Created by jason on 3/8/17.
 */

/**
 * Valid Parentheses
 */
public class E20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()){
            if (c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }
            if (c == ')'){
                if (stack.isEmpty() || stack.pop() != '(')
                    return false;
            }
            if (c == ']'){
                if (stack.isEmpty() || stack.pop() != '[')
                    return false;
            }
            if (c == '}'){
                if (stack.isEmpty() || stack.pop() != '{')
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
