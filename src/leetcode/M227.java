package leetcode;

/**
 * Created by jason on 3/19/17.
 */

import java.util.Stack;

/**
 * Basic Calculator 2
 */
public class M227 {
    public int calculate(String s) {
        int len;
        if(s==null || (len = s.length())==0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        char sign = '+';
        for(int i=0;i<len;i++){
            if(Character.isDigit(s.charAt(i))){
                num = num*10+s.charAt(i)-'0';
            }
            if((!Character.isDigit(s.charAt(i)) &&' '!=s.charAt(i)) || i==len-1){
                if(sign=='-'){
                    stack.push(-num);
                }
                if(sign=='+'){
                    stack.push(num);
                }
                if(sign=='*'){
                    stack.push(stack.pop()*num);
                }
                if(sign=='/'){
                    stack.push(stack.pop()/num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }

        int re = 0;
        for(int i:stack){
            re += i;
        }
        return re;
    }

    //　StackOverFlow
    public int calculate1(String s) {
        int first = 0, second = 0;
        boolean firstOrSecond = true;
        boolean MulOrDiv = true;
        for (int i = 0; i < s.length(); i++) {
            switch(s.charAt(i)){
                case ' ':
                    break;
                case '+':
                    if (firstOrSecond == false){
                        if (MulOrDiv)
                            first *= second;
                        else
                            first /= second;
                        second = 0;
                    }
                    first += calculate(s.substring(i + 1));
                    //break;  cannot break
                    return first;

                case '-':
                    if (firstOrSecond == false){
                        if (MulOrDiv)
                            first *= second;
                        else
                            first /= second;
                        second = 0;
                    }
                    first -= calculate(s.substring(i + 1));
                    return first;
                case '*':
                    firstOrSecond = false;
                    MulOrDiv = true;
                    break;
                case '/':
                    firstOrSecond = false;
                    MulOrDiv = false;
                    break;
                default:
                    if (firstOrSecond) {
                        first *= 10;
                        first += s.charAt(i) - '0';
                    } else {
                        second *= 10;
                        second += s.charAt(i) - '0';
                    }
            }
        }
        return first;
    }

    public static void main(String[] args){
        M227 m227 = new M227();
        m227.calculate("1 + 1");
    }
}
