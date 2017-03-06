package util;

import java.util.EmptyStackException;
import java.util.LinkedList;

/**
 * Created by jason on 3/6/17.
 */
public class MQueue<T> {
    private LinkedList<T> queue;

    public MQueue(){
        queue = new LinkedList<>();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public void clear(){
        queue.clear();
    }

    public T dequeue(){
        return queue.removeLast();
    }

    public void enqueue(T x){
        queue.add(0, x);
    }

    public T peek(){
        return queue.getLast();
    }

    @Override
    public String toString() {
        return queue.toString();
    }

    public static void main(String[] args){
        MQueue<String> mQueue = new MQueue<>();
        mQueue.enqueue("a");
        mQueue.enqueue("b");
        System.out.println(mQueue);
        mQueue.dequeue();
        System.out.println(mQueue);
    }
}
