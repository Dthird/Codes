package leetcode.array;

/**
 * Created by jason on 3/29/17.
 */

import java.util.HashMap;

/**
 * 4 Sum 2
 */
public class M454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                map.put(A[i] + B[j], map.getOrDefault(A[i] + B[j], 0) + 1);
            }
        }
        int res = 0;
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                res += map.getOrDefault(-C[i] - D[j], 0);
            }
        }
        return res;

    }
}
