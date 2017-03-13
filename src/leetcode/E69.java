package leetcode;

/**
 * Created by jiaxing on 17-3-13.
 */

/**
 * Sqrt(x)
 */
public class E69 {


    // newton
    public int mySqrt(int x){
        long r = x;
        while (r*r > x)
            r = (r + x/r) / 2;
        return (int) r;
    }

    // TLE
    public int mySqrt1(int x) {
        if (x == 0 || x == 1)
            return x;
        int low = 1, high = x;

        while(low <= high){
            int mid = (low + high) / 2;
            if (mid * mid <= x && (mid + 1) * (mid + 1) > x)
                return mid;
            else if (mid * mid > x){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}
