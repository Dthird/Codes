package util;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by jason on 3/6/17.
 */
public class MPriorityQueue<T extends Comparable<T>> {
    private ArrayList<T> heap;

    public MPriorityQueue(int capability){
        heap = new ArrayList<>(capability);
    }

    private final int getLeftIndex(int index){
        return 2 * index + 1;
    }

    private final int getRightIndex(int index){
        return 2 * index + 2;
    }

    private final int getParentIndex(int index){
        return (index - 1) / 2;
    }

    public boolean isEmpty(){
        return heap.isEmpty();
    }

    public void clear(){
        heap.clear();
    }

    public T peek(){
        return heap.get(0);
    }

    public void enqueue(T x){
        heap.add(x);
        int i = heap.size() - 1;
        while (i != 0){
            int parent = getParentIndex(i);
            if (heap.get(i).compareTo(heap.get(parent)) > 0){
                return;
            } else{
                T tmp = heap.get(i);
                heap.set(i, heap.get(parent));
                heap.set(parent, tmp);
                i = parent;
            }
        }
    }

    public T dequeue(){
        T res = heap.get(0);
        T last = heap.get(heap.size()-1);
        heap.set(0, last);
        heap.remove(heap.size()-1);
        int i = 0;
        while(i < heap.size()) {
            int left = getLeftIndex(i), right = getRightIndex(i), minIndex;
            if (left >= heap.size()){
                break;
            }
            if (right >= heap.size()){
                minIndex = left;
            } else{
                minIndex = heap.get(left).compareTo(heap.get(right)) < 0 ? left : right;
            }

            if (heap.get(i).compareTo(heap.get(minIndex)) > 0){
                T tmp = heap.get(i);
                heap.set(i, heap.get(minIndex));
                heap.set(minIndex, tmp);
                i = minIndex;
            } else{
                break;
            }
        }
        return res;
    }

    @Override
    public String toString() {
        return heap.toString();
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        MPriorityQueue<Integer> priorityQueue = new MPriorityQueue<>(10);
        int x = in.nextInt();
        while (x != -1){
            priorityQueue.enqueue(x);
            x = in.nextInt();
        }

        System.out.println(priorityQueue);
        while (!priorityQueue.isEmpty()){
            System.out.print(priorityQueue.dequeue() + " ");
            System.out.println(priorityQueue);
        }
    }

}
