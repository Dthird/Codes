package leetcode;

/**
 * Created by jason on 3/8/17.
 */
public class E7 {
    public int reverse(int x) {
        if (x == -2147483648){
            return 0;
        }

        boolean flag = x < 0;
        StringBuilder stringBuilder = new StringBuilder(String.valueOf(Math.abs(x)));
        //System.out.println(stringBuilder.toString());
        long xLong = Long.valueOf(stringBuilder.reverse().toString());


        if(xLong > 2147483647){
            return 0;
        } else{
            return flag ? 0 - (int)xLong : (int)xLong;
        }
    }

    public static void main(String[] args){
        E7 e7 = new E7();
        e7.reverse(-2147483648);
    }
}
