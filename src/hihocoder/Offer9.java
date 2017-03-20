package hihocoder;

/**
 * Created by jason on 3/12/17.
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Offer9{
    public static void main(String[] args){
        Main2.main(args);
    }
}

class Main3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = Integer.valueOf(sc.nextLine());
        for (int k = 0; k < T; k++){
            int N = Integer.valueOf(sc.nextLine());
            int[] weight = new int[N];
            int[] tree = new int[N];

            for (int l = 0; l < N; l++){
                String[] ts = sc.nextLine().split(" ");
                weight[l] = Integer.valueOf(ts[0]);
                tree[l] = Integer.valueOf(ts[1]);
            }

            int sum = 0;
            for (int i = 0; i < N; i++) {
                sum += weight[i];
            }
            if (sum % 3 != 0){
                System.out.println(0);
                continue;
            } else {
                System.out.println(1);
            }

        }
    }
}

class Main1 {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        List<Date> list = new ArrayList<>();
        list.add(df.parse("1972-06-30 23:59:60"));
        list.add(df.parse("1972-12-31 23:59:60"));
        list.add(df.parse("1973-12-31 23:59:60"));
        list.add(df.parse("1974-12-31 23:59:60"));
        list.add(df.parse("1975-12-31 23:59:60"));
        list.add(df.parse("1976-12-31 23:59:60"));
        list.add(df.parse("1977-12-31 23:59:60"));
        list.add(df.parse("1978-12-31 23:59:60"));
        list.add(df.parse("1979-12-31 23:59:60"));
        list.add(df.parse("1981-06-30 23:59:60"));
        list.add(df.parse("1982-06-30 23:59:60"));
        list.add(df.parse("1983-06-30 23:59:60"));
        list.add(df.parse("1985-06-30 23:59:60"));
        list.add(df.parse("1987-12-31 23:59:60"));
        list.add(df.parse("1989-12-31 23:59:60"));
        list.add(df.parse("1990-12-31 23:59:60"));
        list.add(df.parse("1992-06-30 23:59:60"));
        list.add(df.parse("1993-06-30 23:59:60"));
        list.add(df.parse("1994-06-30 23:59:60"));
        list.add(df.parse("1995-12-31 23:59:60"));
        list.add(df.parse("1997-06-30 23:59:60"));
        list.add(df.parse("1998-12-31 23:59:60"));
        list.add(df.parse("2005-12-31 23:59:60"));
        list.add(df.parse("2008-12-31 23:59:60"));
        list.add(df.parse("2012-06-30 23:59:60"));
        list.add(df.parse("2015-06-30 23:59:60"));
        list.add(df.parse("2016-12-31 23:59:60"));


        while (sc.hasNext()) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();

            Date d1 = df.parse(s1);
            Date d2 = df.parse(s2);

            int res = (int) ((d2.getTime() - d1.getTime()) / 1000);
            for (Date l : list){
                if (d2.getTime() < l.getTime()){
                    break;
                }
                if (d1.getTime() >= l.getTime()){
                    continue;
                }

                if (d1.getTime() < l.getTime() && d2.getTime() > l.getTime()){
                    res++;
                }
                if (d2.getTime() == l.getTime()){
                    res ++;
                }
            }

            System.out.println(res);
        }
    }
}

class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            /*string line = sc.nextLine();
            int N = Integer.valueOf(line.split(" ")[0]);
            int M = Integer.valueOf(line.split(" ")[1]);
            */
            int N = sc.nextInt();
            int M = sc.nextInt();

            int[][] board = new int[N][M];
            for (int k = 0; k < N; k++) {
                String tmp = sc.next();
                for (int i = 0; i < tmp.length(); i++) {
                    if (tmp.charAt(i) == '1')
                        board[k][i] = 1;
                }
            }

            int[][] res = new int[N][M];


            for (int i = 0; i < N; i++) {
                Arrays.fill(res[i], Integer.MAX_VALUE);
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (board[i][j] == 0) {
                        dfs(res, board, i, j, 0);
                    }
                }
            }


            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (j != M - 1) {
                        System.out.print(res[i][j] + " ");
                    } else {
                        System.out.print(res[i][j]);
                    }
                }
                System.out.println();
            }


        }
    }

    private static void dfs(int[][] res, int[][] board, int indexi, int indexj, int dis) {
        if (indexi < 0 || indexi > board.length - 1 || indexj < 0 || indexj > board[0].length - 1)
            return;

        if (res[indexi][indexj] > dis) {
            res[indexi][indexj] = dis;
        } else {
            return;
        }
        dfs(res, board, indexi + 1, indexj, dis + 1);
        dfs(res, board, indexi - 1, indexj, dis + 1);
        dfs(res, board, indexi, indexj + 1, dis + 1);
        dfs(res, board, indexi, indexj - 1, dis + 1);
    }
}
