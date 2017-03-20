package leetcode.string;

import java.util.HashMap;

/**
 * Created by jason on 3/8/17.
 */

/**
 * Roman to Integer
 */
public class E13 {
    public int romanToInt(String s) {
        if (s.length() == 0){
            return 0;
        }
        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);
        hashMap.put('D', 500);
        hashMap.put('M', 1000);
        int res = hashMap.get(s.charAt(s.length() - 1));
        for (int i = s.length() - 2; i >= 0; i--) {
            if (hashMap.get(s.charAt(i)) < hashMap.get(s.charAt(i + 1))){
                res -= hashMap.get(s.charAt(i));
            } else{
                res += hashMap.get(s.charAt(i));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        E13 e13 = new E13();
        System.out.println(e13.romanToInt("MCMLXXXIV"));
    }
}
