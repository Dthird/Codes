package intern;

import java.math.BigInteger;
import java.util.*;

/**
 * Created by jiaxing on 17-5-18.
 */
public class HuaweiFX {
}

class FX1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String a = sc.next();
            String b = sc.next();
            BigInteger aBig = new BigInteger(sevTodec(a));
            BigInteger bBig = new BigInteger(sevTodec(b));
            BigInteger resBig = aBig.multiply(bBig);
            System.out.println(decTosev(resBig.toString()));
        }
        sc.close();
    }

    private static String decTosev(String s) {
        BigInteger sBig = new BigInteger(s);
        StringBuilder sb = new StringBuilder();
        BigInteger sev = new BigInteger("7");
        while (sBig.compareTo(sev) >= 0) {
            sb.insert(0, (sBig.mod(sev).toString()));
            sBig = sBig.divide(sev);
        }
        sb.insert(0, sBig.toString());
        return sb.toString();
    }

    private static String sevTodec(String s) {
        long res = 0;
        for (char c : s.toCharArray()) {
            res *= 7;
            res += c - '0';
        }
        return String.valueOf(res);
    }
}

class FX2 {
    static HashMap<String, ArrayList<String>> map;
    static HashSet<String> linkedFun;
    static Queue<String> queue;

    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            map = new HashMap<>();
            linkedFun = new HashSet<>();
            queue = new LinkedList<>();
            int N = sc.nextInt();
            for (int i = 0; i < N; i++) {
                String A = sc.next();
                String B = sc.next();
                if (map.containsKey(A)){
                    map.get(A).add(B);
                } else {
                    ArrayList<String> list = new ArrayList<>();
                    list.add(B);
                    map.put(A, list);
                }
            }

            link();
            System.out.println(linkedFun.size());

        }
        sc.close();
    }

    private static void link(){
        queue.offer("main");
        linkedFun.add("main");
        while (!queue.isEmpty()){
            String ele = queue.poll();
            if (!map.containsKey(ele)){
                continue;
            }
            for (String s : map.get(ele)){
                if (linkedFun.contains(s))
                    continue;
                else {
                    linkedFun.add(s);
                    queue.offer(s);
                }
            }
        }
    }
}

class FX3 {
    static int mincost;
    static ArrayList<Integer> minpath = new ArrayList<>();
    static int[][] map = {
            {0, 2, 10, 5, 3, 1000},
            {1000, 0, 12, 1000, 1000, 10},
            {1000, 1000, 0, 1000, 7, 1000},
            {2, 1000, 1000, 0, 2, 1000},
            {4, 1000, 1000, 1, 0, 1000},
            {3, 1000, 1, 1000, 2, 0}
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> rs;
        while (sc.hasNext()) {
            rs = new ArrayList<>();
            int x = sc.nextInt();
            int y = sc.nextInt();
            ArrayList<Integer> path = new ArrayList<>();
            if (y == 5) {
                System.out.println(1000);
                System.out.println("[]");
                continue;
            }

            if (y != 0)
                for (int i = 0; i < 6; ++i) {
                    map[i][y - 1] = 1000;
                }

            boolean[] used = new boolean[7];
            mincost = -1;
            used[5] = true;
            dfs(path, 0, used, x, 5);
            if (mincost >= 1000) System.out.println(1000);
            else System.out.println(mincost);

            if (mincost >= 1000) {
                System.out.println("[]");
                continue;
            }

            rs.add(5);
            for (Integer aMinpath : minpath) {
                rs.add(aMinpath);
            }

            System.out.println(rs);
        }
        sc.close();
    }

    private static void dfs(ArrayList<Integer> path, int cost, boolean[] used, int target, int next) {
        if (next == target) {
            if (mincost == -1 || cost < mincost) {
                mincost = cost;
                minpath = new ArrayList<>(path);
            }
        }

        for (int i = 1; i <= 6; ++i) {
            if (!used[i] && i != next) {
                used[i] = true;
                path.add(i);
                dfs(path, cost + map[next - 1][i - 1], used, target, i);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }

    }
}
