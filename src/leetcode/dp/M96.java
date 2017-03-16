package leetcode.dp;

/**
 * Created by jason on 3/16/17.
 */

/**
 * Unique Binary Search Tree
 */
public class M96 {
    public int numTrees(int n) {
        int [] memo = new int[n+1];
        memo[0]= 1;
        memo[1] = 1;
        for(int level = 2; level <=n; level++)
            for(int root = 1; root<=level; root++)
                memo[level] += memo[level-root]*memo[root-1];
        return memo[n];
    }
}
