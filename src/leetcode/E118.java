package leetcode;

/**
 * Created by jason on 3/16/17.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Pascal's Triangle
 */
public class E118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0)
            return res;
        List<Integer> tmp = new ArrayList<>();
        tmp.add(1);
        res.add(new ArrayList<>(tmp));

        for (int i = 1; i < numRows; i++) {
            tmp.clear();
            tmp.add(1);
            for (int j = 0; j < res.get(i - 1).size() - 1; j++) {
                tmp.add(res.get(i - 1).get(j) + res.get(i - 1).get(j + 1));
            }
            tmp.add(1);
            res.add(new ArrayList<>(tmp));
        }
        return res;
    }
}
