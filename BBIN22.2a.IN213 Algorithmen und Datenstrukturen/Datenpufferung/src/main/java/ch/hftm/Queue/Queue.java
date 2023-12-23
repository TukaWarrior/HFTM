package ch.hftm.Queue;

public interface Queue {
    
    public void insert(Object o) throws ArrayIndexOutOfBoundsException;
    public Object remove();
    public void isEmpty();
    public boolean isFull();
}