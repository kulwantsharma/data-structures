package main.java.stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public final class ReverseStack {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= 10; i++) {
            stack.push(i);
        }
        System.out.println("Before Reverse");
        System.out.println(stack);

        System.out.println("After Reverse");
        reverseStackUsingRecursion(stack);
        System.out.println(stack);

        System.out.println("Reverse Iterative");
        reverseStackUsingIterative(stack);
        System.out.println(stack);


    }

    private static void reverseStackUsingIterative(Stack<Integer> stack) {

        Queue<Integer> queue = new LinkedList<>();

        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }

    }

    private static void reverseStackUsingRecursion(Stack<Integer> stack) {

        if (stack.isEmpty()) {
            return;
        }

        Integer popped = stack.pop();
        reverseStackUsingRecursion(stack);
        insertAtBeginning(stack, popped);
    }

    private static void insertAtBeginning(Stack<Integer> stack, Integer item) {
        if (stack.isEmpty()) {
            stack.push(item);
            return;
        }
        Integer popped = stack.pop();
        insertAtBeginning(stack, item);
        stack.push(popped);
    }
}
