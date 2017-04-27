package intern;

/**
 * Created by jason on 4/27/17.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import static java.lang.Math.*;

class Baidu3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            int k = sc.nextInt();
            System.out.println(cal(n, k));
        }
    }
    private static int cal(int n, int k){
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
            dp[0][i] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = (dp[i-1][j] * (j + 1) + dp[i-1][j-1] * (i - j)) % 2017;
            }
        }
        return dp[n][k];
    }
}

public class Baidu{
    static class Point{
        public int x;
        public int y;
        public int z;
        Point(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    private static double distance(Point a, Point b) {
        return sqrt(pow(a.x-b.x, 2)+pow(a.y-b.y,2)+pow(a.z-b.z,2));
    }

    private static double area(Point a, Point b, Point c) {
        double ab = distance(a, b), bc = distance(b, c), ac = distance(a, c);
        double p = (ab+bc+ac)/2;
        return sqrt(p*(p-ab)*(p-bc)*(p-ac));
    }

    private static double maxArea(ArrayList<Point> points) {
        double res =  0;
        for (int i = 0; i < points.size(); ++i) {
            for (int j = i+1; j < points.size(); ++j) {
                for (int k = j+1; k < points.size(); ++k) {
                    res = max(res, area(points.get(i), points.get(j), points.get(k)));
                }
            }
        }
        return res;
    }

    private static double maxArea(ArrayList<Point> a, ArrayList<Point> b, ArrayList<Point> c) {
        double res = 0;
        for (int i = 0; i < a.size(); ++i) {
            for (int j = 0; j < b.size(); ++j) {
                for (int k = 0; k < c.size(); ++k) {
                    res = max(res, area(a.get(i), b.get(j), c.get(k)));
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        HashMap<String, ArrayList<Point>> map = new HashMap<>();
        while(sc.hasNext()){
            int N = sc.nextInt();
            for (int i = 0; i < N; i++) {
                String color = sc.next();
                int x = sc.nextInt();
                int y = sc.nextInt();
                int z = sc.nextInt();
                Point p = new Point(x,y,z);
                if (map.containsKey(color)){
                    map.get(color).add(p);
                }else {
                    ArrayList<Point> tmp = new ArrayList<>();
                    tmp.add(p);
                    map.put(color, tmp);
                }
            }

            double max_area = 0;
            if (map.containsKey("R"))
                max_area = max(max_area, maxArea(map.get("R")));
            if (map.containsKey("G"))
                max_area = max(max_area, maxArea(map.get("G")));
            if (map.containsKey("B"))
                max_area = max(max_area, maxArea(map.get("B")));
            if (map.containsKey("R") && map.containsKey("G") && map.containsKey("B"))
                max_area = max(max_area, maxArea(map.get("R"), map.get("G"), map.get("B")));
            System.out.println(max_area);
            map.clear();
        }
    }
}


