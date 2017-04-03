package intern;

import java.util.Scanner;

/**
 * Created by jiaxing on 17-3-31.
 */
public class MS {

}

class D{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
    }
}

class C{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
    }
}

class B{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
    }
}

class A{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int P = sc.nextInt();
            int Q = sc.nextInt();
            int N = sc.nextInt();
            System.out.println(quest(P, Q, N));
        }
    }
    private static double quest(int P, int Q, int N) {
        if (P == 100)
            return N;
        double[][] dp = new double[2][101];
        for (int i = 0; i <= 100; i++) {
            dp[0][i] = 0;
        }
        int nextI = 1;
        for (int i = 1; i <= N; i++) {
            for (int j = 100; j >= 0; j--) {
                dp[nextI][j] = 1;
                int nextJ = (int)(P / Math.pow(2, N - i + 1));
                dp[nextI][j] += (double)j / 100 * dp[1 - nextI][nextJ];
                nextJ = Math.min(100, j + Q);
                dp[nextI][j] += (double)(100 - j) / 100 * dp[nextI][nextJ];
            }
            nextI = 1 - nextI;
        }
        return dp[1 - nextI][P];
    }
}