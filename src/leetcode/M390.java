package leetcode;

/**
 * Created by jason on 4/6/17.
 */

/**
 *
 * Elimination Game
 */
public class M390 {
    public int lastRemaining(int n) {
        int step = 1, remaining = n, head = 1;
        boolean isLeftToRight = true;
        while (remaining > 1){
            if (isLeftToRight || remaining % 2 == 1)
                head += step;
            remaining >>= 1;
            step <<= 1;
            isLeftToRight = !isLeftToRight;

        }
        return head;
    }

    public static void main(String[] args){
        M390 m390 = new M390();
        System.out.println(m390.lastRemaining(9));
    }
}
