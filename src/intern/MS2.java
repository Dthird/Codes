package intern;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by jiaxing on 17-4-8.
 */
public class MS2 {

}

class D2{
    static class Task {
        public int id;
        public int F;
        public int IN;
        public int IP;
        public int C;
        public Task(int id, int F, int IN, int IP, int C){
            this.id = id;
            this.F = F;
            this.IN = IN;
            this.IP = IP;
            this.C = C;
        }
    }

    static HashMap<Integer, ArrayList<Task>> map = new HashMap<>();

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int N = sc.nextInt();
            for (int i = 0; i < N; i++) {
                int id = i + 1;
                int F = sc.nextInt();
                int IN = sc.nextInt();
                int IP = sc.nextInt();
                int C = sc.nextInt();
                Task task = new Task(id, F, IN, IP, C);
                if (map.containsKey(F)){
                    map.get(F).add(task);
                } else {
                    map.put(F, new ArrayList<>());
                    map.get(F).add(task);
                }
            }

            System.out.println(minCost(new int[]{0}));

            for (Map.Entry<Integer, ArrayList<Task>> entry : map.entrySet()){
                System.out.print(entry.getKey() + ":");
                for (Task t : entry.getValue()){
                    System.out.print(t.id + " ");
                }
                System.out.println();
            }



        }
        sc.close();
    }

    private static long minCost(int[] nums){
        for (int num : nums){

        }
        return 0;
    }
}

class C2{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){

        }
        sc.close();
    }
}

class B2{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            long N = sc.nextLong();
            long Q = sc.nextLong();
            long time = 0, allTime = Integer.MAX_VALUE, robotNum = 1;
            while (true){
                long timeUsed = time + (N % robotNum == 0 ? N / robotNum : N / robotNum + 1);
                if (timeUsed >= allTime) {
                    System.out.println(allTime);
                    break;
                }
                time += Q;
                robotNum *= 2;
                allTime = timeUsed;
            }
        }
        sc.close();
    }
}

class A2{
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int N = sc.nextInt();
            int[][] board = new int[N][N];
            for (int i = 0; i < N; i++) {
                int row = sc.nextInt();
                int col = sc.nextInt();
            }
        }
        sc.close();
    }

}
