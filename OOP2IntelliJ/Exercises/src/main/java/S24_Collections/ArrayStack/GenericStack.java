package S24_Collections.ArrayStack;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class GenericStack<T> {

//    Declaration of variable ArrayList named items of the type generic
    private ArrayList<T> items;

//    Constructor that initializes a new ArrayList
    public GenericStack() {
        items = new ArrayList<>();
    }


    public void push(T item) {
        items.add(item);
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int lastIndex = items.size() - 1;
        T poppedItem = items.get(lastIndex);
        items.remove(lastIndex);
        return poppedItem;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public static void main(String[] args) {
        GenericStack<String> stack = new GenericStack<>();
        stack.push("1");
        stack.push("2");
        stack.push("3");
        stack.push("4");
        stack.push("5");

        System.out.println(stack.pop()); // 3
        System.out.println(stack.pop()); // 2
        System.out.println(stack.pop()); // 1
        System.out.println(stack.pop()); // 1
        System.out.println(stack.pop()); // 1

        boolean isEmpty = stack.isEmpty();
        System.out.println("Is the stack empty? " + isEmpty);
    }
}
