package leetcode;

/**
 * Created by jason on 3/12/17.
 */
public class M50 {
    public double myPow(double x, int n) {
        if (x == 0)
            return 0.0;
        if (n == 0)
            return 1.0;
        if (n == 1)
            return x;

        if (n < 0)
            x = 1 / x;
        if (n != Integer.MIN_VALUE)
            n = Math.abs(n);
        else
            n = Integer.MAX_VALUE - 1; // keep even
        return n % 2 == 1 ? x * myPow(x * x, n/2) : myPow(x * x, n / 2);
    }
}
