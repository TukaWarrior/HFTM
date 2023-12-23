package ch.hftm.Stack;

public class StackClient {
    
    public static void main(String[] args){
        ArrayStack stack = new ArrayStack();
        System.out.println(stack.pop());
        stack.push(5);
        stack.push(10);
        stack.push(50);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}