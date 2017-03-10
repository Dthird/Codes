package leetcode;

/**
 * Created by jason on 3/9/17.
 */
public class E38 {
    public String countAndSay(int n) {
        if (n == 0){
            return "";
        }
        if (n == 1){
            return "1";
        }

        String res = "1";
        while (n > 1) {
            res = convert(res);
            n--;
        }
        return res;
    }

    public String convert(String s){
        StringBuilder stringBuilder = new StringBuilder("");
        int count = 1;
        for (int i = 1; i < s.length(); i++){
            if (s.charAt(i) == s.charAt(i - 1)){
                count++;
            } else {
                stringBuilder.append(count);
                stringBuilder.append(s.charAt(i - 1));
                count = 1;
            }
        }
        stringBuilder.append(count);
        stringBuilder.append(s.charAt(s.length() - 1));
        return stringBuilder.toString();
    }

}
