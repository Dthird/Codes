package leetcode.combinationsandpermutations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jason on 3/11/17.
 */
public class M77_ {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n == 0 || k == 0 || k > n)
            return res;
        if (n == k){
            List<Integer> tmp = new ArrayList<>();
            for (int i = 1; i <= n; i++)
                tmp.add(i);
            res.add(tmp);
            return res;
        }
        if (k == 1){

            for (int i = 1; i <= n; i++){
            }
        }
        return res;
    }




    public static void main(String[] args){
        M77_ m77 = new M77_();
        System.out.println(m77.combine(4, 2));
    }
}
