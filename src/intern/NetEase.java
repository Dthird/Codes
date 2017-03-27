package intern;

import java.util.*;

/**
 * Created by jiaxing on 17-3-25.
 */
public class NetEase {
    public static void main(String[] args){
        NetEase netEase = new NetEase();
        System.out.println();
    }

}

class Main3{
    private static int count = 0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            String[] strings = new String[n];
            for (int k = 0; k < n; k++) {
                strings[k] = sc.next();
            }

            dfs(new ArrayList<Character>(), strings, 0);
            System.out.println(count);
            count = 0;
        }
    }

    private static void dfs(ArrayList<Character> tmp, String[] strings, int index){
        if (index == strings.length){
            count++;
            return;
        }

        for (int i = 0; i < strings[index].length(); i++) {
            if (!tmp.contains(strings[index].charAt(i))){
                tmp.add(strings[index].charAt(i));
                dfs(tmp, strings, index + 1);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    private static boolean isValid(List<Character> tmp, String s){
        for (Character c : tmp){
            if (s.contains(c + ""));
                return false;
        }
        return true;
    }

}

class  Main2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int n = sc.nextInt();
            int[] tX = new int[n];
            for (int i = 0; i < n; i++) {
                tX[i] = sc.nextInt();
            }
            int[] tY = new int[n];
            for (int i = 0; i < n; i++) {
                tY[i] = sc.nextInt();
            }
            int gx = sc.nextInt();
            int gy = sc.nextInt();
            int walkTime = sc.nextInt();
            int taxiTime = sc.nextInt();

            System.out.println(getTime(tX, tY, gx, gy, walkTime, taxiTime));

        }
    }

    private static int getTime(int[] tX, int[] tY, int gx, int gy, int walk, int taxi){
        int time = distance(0 ,0, gx, gy) * walk;
        for (int i = 0; i < tX.length; i++) {
            time = Math.min(time, distance(0, 0, tX[i], tY[i]) * walk + distance(gx, gy, tX[i], tY[i]) * taxi);
        }
        return time;
    }

    private static int distance(int x1, int y1, int x2, int y2){
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}

class Main1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int n = sc.nextInt();
            LinkedList<Integer> res = new LinkedList<>();
            for (int k = 0; k < n; k++) {
                int tmp = sc.nextInt();
                if (res.contains(tmp)) {
                    res.remove(res.indexOf(tmp));
                    res.addLast(tmp);
                } else {
                    res.addLast(tmp);
                }
            }

            for (int i = 0; i < res.size() - 1; i++) {
                System.out.print(res.get(i) + " ");
            }
            System.out.println(res.getLast());
        }
    }
}
