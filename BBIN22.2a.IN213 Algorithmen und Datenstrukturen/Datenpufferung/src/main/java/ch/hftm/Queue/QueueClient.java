package ch.hftm.Queue;

public class QueueClient {
    
    public static void main(String[] args){
        ArrayQueue q = new ArrayQueue();

        q.insert(5);
        q.insert("String");
        q.insert(15);
        q.insert(20);
        q.insert(25);
        System.out.println(q.remove());
        q.insert(30);
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
        System.out.println(q.remove());
    }
}