package leetcode;

/**
 * Created by jason on 3/11/17.
 */

/**
 * Multiply Strings
 */
public class M43 {

    public String multiply(String num1, String num2) {
        if (num1.length() == 0 || num2.length() == 0)
            return null;
        if (num1.length() == 1 && num1.charAt(0) == '0' || num2.length() == 1 && num2.charAt(0) == '0')
            return "0";
        String res = "0", tens = "";
        for (int i = num2.length() - 1; i >= 0; i--){
            String tmp = multiplyWithOne(num1, num2.charAt(i));
            tmp += tens;
            res = add(res, tmp);
            tens += "0";

        }
        return res;
    }

    public String add(String s1, String s2){
        int carry = 0;
        StringBuilder stringBuilder = new StringBuilder("");
        int i, j;
        for (i = s1.length() - 1, j = s2.length() - 1; i >= 0 && j >= 0; i--, j--){
            int tmp = (s1.charAt(i) - '0') + (s2.charAt(j) - '0') + carry;
            carry = tmp / 10;
            stringBuilder.append(tmp % 10);
        }

        if (i >= 0){
            while (i >= 0){
                int tmp = s1.charAt(i) - '0' + carry;
                carry = tmp / 10;
                stringBuilder.append(tmp % 10);
                i--;
            }
        }
        if (j >= 0){
            while (j >= 0){
                int tmp = s2.charAt(j) - '0' + carry;
                carry = tmp / 10;
                stringBuilder.append(tmp % 10);
                j--;
            }
        }
        if (carry > 0)
            stringBuilder.append(carry);
        stringBuilder.reverse();
        return stringBuilder.toString();

    }

    public String multiplyWithOne(String s, char c){
        int carry = 0;
        StringBuilder stringBuilder = new StringBuilder("");
        for (int i = s.length() - 1; i >= 0; i--){
            int tmp = (c - '0') * (s.charAt(i) - '0') + carry;
            carry = tmp / 10;
            stringBuilder.append(tmp % 10);
        }
        if (carry != 0 )
            stringBuilder.append(carry);
        stringBuilder.reverse();
        return stringBuilder.toString();
    }

    public static void main(String[] args){
        M43 m43 = new M43();
        //System.out.println(m43.multiplyWithOne("1234", '9') + ' ' + 1234 * 9);
        //System.out.println(m43.add("9999567", "532") + " " + (9999567 + 532));
        System.out.println(m43.multiply("1234", "4321") + " " + 1234 * 4321);
    }
}
