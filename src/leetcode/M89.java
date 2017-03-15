package leetcode;

/**
 * Created by jason on 3/15/17.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Gray Code
 */
public class M89 {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        if (n == 0) {
            res.add(0);
            return res;
        }
        if (n == 1){
            res.add(0);
            res.add(1);
            return res;
        }

        List<Integer> tmp = grayCode(n -1);
        res.addAll(tmp);
        for (int i = tmp.size() - 1; i >= 0; i--) {
            res.add(tmp.get(i) + (1 << (n - 1)));
        }

        return res;
    }
}
