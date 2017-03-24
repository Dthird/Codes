package leetcode.array;

/**
 * Created by jason on 3/24/17.
 */

import java.util.*;

/**
 * Top K Frequent Elements
 */
public class M347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            if (map.containsKey(i))
                map.put(i, map.get(i) + 1);
            else
                map.put(i, 1);
        }
        PriorityQueue<Pair> queue = new PriorityQueue<>(k, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.getSecond() > o2.getSecond())
                    return -1;
                else if (o1.getSecond() < o2.getSecond())
                    return 1;
                else
                    return 0;
            }
        });
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            queue.offer(new Pair(entry.getKey(), entry.getValue()));
        }

        while(k-- > 0)
            res.add(queue.poll().getFirst());

        return res;
    }

    public static void main(String[] args){
        PriorityQueue<Pair> queue = new PriorityQueue<>(5, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                if (o1.getSecond() > o2.getSecond())
                    return 1;
                else if (o1.getSecond() < o2.getSecond())
                    return -1;
                else
                    return 0;
            }
        });

        Pair a = new Pair(1,1);
        Pair b = new Pair(2,2);
        queue.offer(b);
        queue.offer(a);
        a.setSecond(3);
        while (!queue.isEmpty())
            System.out.println(queue.poll());

    }

    static class Pair {
        private int first;
        private int second;

        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }

        public int getFirst() {
            return first;
        }

        public int getSecond() {
            return second;
        }

        public void setFirst(int first) {
            this.first = first;
        }

        public void setSecond(int second) {
            this.second = second;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("first: ").append(first).append(" ").append("second: ").append(second);
            return stringBuilder.toString();
        }
    }

}
