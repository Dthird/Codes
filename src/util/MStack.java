package util;

import java.util.EmptyStackException;
import java.util.LinkedList;

/**
 * Created by jason on 3/6/17.
 */
public class MStack<T>{
    private LinkedList<T> stack;

    public MStack(){
        stack = new LinkedList<>();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public void clear(){
        stack.clear();
    }

    public void push(T x){
        stack.addLast(x);
    }

    public T pop(){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        T res = stack.removeLast();
        return res;
    }

    public T peak(){
        if (isEmpty()){
            throw new EmptyStackException();
        }
        return stack.getLast();
    }

    @Override
    public String toString() {
        return stack.toString();
    }
}
