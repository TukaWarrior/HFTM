package ch.hftm.Stack;

public class ArrayStack {
    public static final int STACK_SIZE = 5;
    private Object[] container = new Object[5];
    private int aktIdx = 0;

    public void push(Object o){
        if (isFull()){
            throw new ArrayIndexOutOfBoundsException();
        } else {
            container[aktIdx++] = o; // ++ after aktIdx so it increases after the access. 
        }
    }

    public Object pop(){
        if (isEmpty()) {
            return null;
        }
        return container[--aktIdx]; // -- before aktIdx so it decreases before the access. 
    }

    public boolean isEmpty(){
        return aktIdx == 0;
    }

    public boolean isFull(){
        return aktIdx == STACK_SIZE;
    }
}