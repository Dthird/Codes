package intern;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by jason on 4/7/17.
 */
public class HuaWei {
    static PriorityQueue<Task> priorityQueue= new PriorityQueue<>(new Comparator<Task>() {
        @Override
        public int compare(Task o1, Task o2) {
            if (o1.priority < o2.priority)
                return 1;
            else if (o1.priority > o2.priority)
                return -1;
            else
                return 0;
        }
    });

    static int clock = 0;


    // input [1.80.1.10]|[2.20.11.15]|[3.50.21.10]|[4.130.31.10]|[5.100.41.10]
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            Task[] tasks = new Task[5];
            String[] tasksString = sc.next().split("\\|");
            for (int i = 0; i < tasks.length; i++) {
                String[] task = tasksString[i].split("\\.");
                int id = Integer.parseInt(task[0].substring(1));
                int pri = Integer.parseInt(task[1]);
                int start = Integer.parseInt(task[2]);
                int time = Integer.parseInt(task[3].substring(0, task[3].length() - 1));
                tasks[i] = new Task(id, pri, start, time);
            }
            schedule(tasks, 200);
        }
    }

    private static void schedule(Task[] tasks, int allTime){
        Arrays.sort(tasks, new Comparator<Task>() {
            @Override
            public int compare(Task o1, Task o2) {
                if (o1.start < o2.start)
                    return -1;
                else if (o1.start > o2.start)
                    return 1;
                else
                    return 0;
            }
        });

        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        int curTask = 0;
        int prev = 0;
        for (; clock <= allTime; clock++){
            if (i < 5 && clock == tasks[i].start){
                priorityQueue.add(tasks[i]);
                i++;
                if (curTask != priorityQueue.peek().id){
                    System.out.println(clock);
                    stringBuilder.append(curTask + "." + (clock - prev) + "|");
                    prev = clock;
                    curTask = priorityQueue.peek().id;
                }
            }
            if (priorityQueue.isEmpty()){
                curTask = 0;
            } else {
                Task tmp = priorityQueue.peek();
                if (tmp.id != curTask){
                    System.out.println(clock);
                    stringBuilder.append(curTask + "." + (clock - prev) + "|");
                    curTask = tmp.id;
                    prev = clock;
                }
                if (tmp.time == 0){
                    priorityQueue.poll();
                    prev = clock;
                    continue;
                } else
                    tmp.time--;
            }
        }
        stringBuilder.append(curTask + "." + (clock - prev) + "|");
        System.out.println(stringBuilder.toString());
        clock = 0;
        priorityQueue.clear();
    }

    static class Task{
        public int id;
        public int priority;
        public int start;
        public int time;
        public Task(int id, int priority, int start, int time){
            this.id = id;
            this.priority = priority;
            this.start = start;
            this.time = time;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("ID: " + id + " PRIORITY: " + priority + " START: " + start + " TIME: " + time);
            return stringBuilder.toString();
        }
    }

}
