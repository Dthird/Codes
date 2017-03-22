package leetcode;

/**
 * Created by jason on 3/22/17.
 */

/**
 * Power of Three
 */
public class E326 {

    public boolean isPowerOfThree(int n) {
        return ( n>0 &&  1162261467%n==0);
    }

    // WA
    public boolean isPowerOfThree1(int n) {
        double res = Math.log(n) / Math.log(3);
        return res - (int)res == 0;
    }
}
