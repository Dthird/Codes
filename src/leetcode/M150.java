package leetcode;

/**
 * Created by jason on 3/18/17.
 */

import java.util.Stack;

/**
 * Evaluate Reverse Polish Notation
 */
public class M150 {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        int first = 0, second = 0;
        for (String s : tokens){
            switch (s){
                case "+":
                    second = Integer.valueOf(stack.pop());
                    first = Integer.valueOf(stack.pop());
                    stack.push(String.valueOf(first + second));
                    break;
                case "-":
                    second = Integer.valueOf(stack.pop());
                    first = Integer.valueOf(stack.pop());
                    stack.push(String.valueOf(first - second));
                    break;
                case "*":
                    second = Integer.valueOf(stack.pop());
                    first = Integer.valueOf(stack.pop());
                    stack.push(String.valueOf(first * second));
                    break;
                case "/":
                    second = Integer.valueOf(stack.pop());
                    first = Integer.valueOf(stack.pop());
                    stack.push(String.valueOf(first / second));
                    break;
                default:
                    stack.push(s);
            }
        }
        return Integer.valueOf(stack.pop());
    }
}
