package leetcode;

/**
 * Created by jason on 3/27/17.
 */

/**
 * Nth Digit
 */
public class E400 {

    public int findNthDigit(int n) {
        StringBuilder stringBuilder = new StringBuilder(n);
        for (int i = 1; i <= n; i++) {
            stringBuilder.append(i);
            if (stringBuilder.length() >= n)
                break;
        }
        return stringBuilder.toString().charAt(n - 1) - '0';
    }

    public static void main(String[] args){
        E400 e400 = new E400();
        e400.findNthDigit(3);
    }
}
