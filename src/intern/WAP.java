package intern;

/**
 * Created by jiaxing on 17-5-29.
 */

import java.util.Scanner;

public class WAP {

}



class WAP1 {
    private static long[][] memo = new long[1001][1001];

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            int n = in.nextInt();
            int k = in.nextInt();
            System.out.println(solve(n, k));
        }
    }

    public static int solve(int n, int k) {
        if (n == 0)
            return 0;
        if (k == 0)
            return 1;

        if (memo[n][k] != 0)
            return (int)(memo[n][k] % 10000);

        long sum = 0;
        for (int i = 0; i <= k; i++)
        {
            if (i <= n - 1)
                sum += solve(n - 1, k - i);
        }
        memo[n][k] = sum;

        return (int)(sum % 10000);
    }
}
