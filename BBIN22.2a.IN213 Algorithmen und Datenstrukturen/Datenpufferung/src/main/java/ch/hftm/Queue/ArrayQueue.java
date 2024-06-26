package ch.hftm.Queue;

public class ArrayQueue implements Queue{

    public static final int ARRAYLEN = 5;
    private Object[] container = new Object[ARRAYLEN];
    private int readIdx = 0;
    private int writeIdx = 0;
    private int nbrOfItems = 0;

    @Override
    public void insert(Object o) throws ArrayIndexOutOfBoundsException {
        if (nbrOfItems >= ARRAYLEN) {
            throw new ArrayIndexOutOfBoundsException();
        }

        container[writeIdx++ % ARRAYLEN] = o;
        nbrOfItems++;

        // Original code. Unsure if working properly.
        // writeIdx = writeIdx % ARRAYLEN;
        // container[++writeIdx] = o;
        // nbrOfItems++;
    }

    @Override
    public Object remove() {
        if (nbrOfItems <= 0) {
            return null;
        }

        // Original code. Unsure if working properly. 
        // nbrOfItems--;
        // Object value = container[readIdx];
        // readIdx = readIdx % ARRAYLEN;
        // return container [++readIdx];
        
        Object value = container[readIdx];
        readIdx = (readIdx + 1) % ARRAYLEN;
        nbrOfItems--;
        return value;
    }

    public boolean isEmpty() {
        return nbrOfItems == 0;
    }

    public boolean isFull(){
        return nbrOfItems == ARRAYLEN;
    }
}