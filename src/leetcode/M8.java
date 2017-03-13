package leetcode;

/**
 * Created by jason on 3/8/17.
 */

/**
 * String to Integer (atoi)
 */
public class M8 {
    public int myAtoi(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : str.toCharArray()){
            if (c == ' '){
                if (stringBuilder.length() == 0) {
                    continue;
                } else{
                    break;
                }
            }
            if (c == '+' || c == '-'){
                if (stringBuilder.length() == 0) {
                    stringBuilder.append(c);
                    continue;
                } else{
                    break;
                }
            }

            if ( c < '0' || c > '9'){
                break;
            }

            stringBuilder.append(c);
        }

        String trueStr = stringBuilder.toString();
        if (trueStr.length() == 0){
            return 0;
        }
        if (trueStr.length() == 1 && (trueStr.charAt(0) == '+' || trueStr.charAt(0) == '-')){
            return 0;
        }

        int i = 0;
        boolean flag = false;
        if (trueStr.charAt(0) == '+'){
            i++;
        }
        if (trueStr.charAt(0) == '-'){
            i++;
            flag = true;
        }

        double x = 0;
        for (; i < trueStr.length(); i++){
            x *= 10;
            x += trueStr.charAt(i) - '0';
        }

        if (flag){
            x = -x;
        }

        if (x > Integer.MAX_VALUE || x < Integer.MIN_VALUE){
            if (flag){
                return Integer.MIN_VALUE;
            } else{
                return Integer.MAX_VALUE;
            }
        }

        return (int)x;
    }

    public static void main(String[] args){

    }
}
