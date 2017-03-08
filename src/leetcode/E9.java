package leetcode;

/**
 * Created by jason on 3/8/17.
 */
public class E9 {
    public boolean isPalindrome(int x) {
        if (x < 0){
            return false;
        }

        if (x / 10 == 0){
            return true;
        }

        int tmp = x;
        int rev = 0;
        while (x > 0){
            rev *= 10;
            rev += x % 10;
            x /= 10;
        }

        return tmp == rev;
    }

    public static void main(String[] args){
        E9 e9 = new E9();
        System.out.println(e9.isPalindrome(11));
    }
}
