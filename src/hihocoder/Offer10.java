package hihocoder;

import java.util.Scanner;

/**
 * Created by jason on 3/19/17.
 */
public class Offer10 {
}

class Main10_1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            String s = sc.next();
            System.out.println(judge(s) ? "YES" : "NO");
        }
    }

    private static boolean judge(String s){
        int countL = 0, countA = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A'){
                countL = 0;
                countA++;
            } else if (s.charAt(i) == 'L'){
                countL++;
            } else{
                countL = 0;
            }
            if (countA > 1 || countL > 2)
                return false;
        }
        return true;
    }
}
