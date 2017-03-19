package leetcode;

/**
 * Created by jason on 3/19/17.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Different Ways to And Parentheses
 */
public class M241 {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>(), first, second;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*') {
                first = diffWaysToCompute(input.substring(0, i));
                second = diffWaysToCompute(input.substring(i + 1));

                for (Integer it1 : first) {
                    for (Integer it2 : second) {
                        int c = 0;
                        switch (input.charAt(i)) {
                            case '+':
                                c = it1 + it2;
                                break;
                            case '-':
                                c = it1 - it2;
                                break;
                            case '*':
                                c = it1 * it2;
                                break;
                        }
                        res.add(c);
                    }
                }
            }
        }

        if (res.size() == 0)
            res.add(Integer.valueOf(input));
        return res;
    }

}
