package leetcode;

/**
 * Created by jason on 3/8/17.
 */

/**
 * ZigZag Conversion
 */
public class M6 {
    public String convert(String s, int numRows) {
        if (numRows == 1){
            return s;
        }

        String[] slist = new String[numRows];
        for (int i = 0; i < slist.length; i++){
            slist[i] = "";

        }
        int i = 0;
        boolean flag = true;
        for (char c : s.toCharArray()){
            slist[i] += c;
            if (i == 0){
                flag = true;
            }
            if (i == numRows - 1){
                flag = false;
            }
            if (flag){
                i++;
            } else{
                i--;
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (String s1 : slist){
            stringBuilder.append(s1);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args){
        M6 m6 = new M6();
        System.out.println(m6.convert("PAYPALISHIRIN", 3));
    }
}
