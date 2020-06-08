package main.java.stack;

import java.util.Stack;

public final class SortStack {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(1);
        stack.push(4);
        stack.push(3);
        stack.push(6);
        stack.push(2);

        System.out.println("Before Sorting");
        System.out.println(stack);

//        sortStackUsingRecursion(stack);
//        System.out.println("After Sorting");
//        System.out.println(stack);

        sortStackUsingIterative(stack);
        System.out.println("After Sorting");
        System.out.println(stack);

    }

    private static void sortStackUsingIterative(Stack<Integer> s1) {

        Stack<Integer> s2 = new Stack<>();

        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }

        while (!s2.isEmpty()) {

            int poppedItem = s2.pop();
            int count = 0;

            while (!s1.isEmpty() && s1.peek() > poppedItem) {
                count++;
                s2.push(s1.pop());
            }
            s1.push(poppedItem);

            while (count > 0) {
                s1.push(s2.pop());
                count--;
            }

        }


    }

    private static void sortStackUsingRecursion(Stack<Integer> stack) {

        if (stack.isEmpty()) return;
        int popped = stack.pop();
        sortStackUsingRecursion(stack);
        sortStackUsingRecursionUtil(stack, popped);
    }

    private static void sortStackUsingRecursionUtil(Stack<Integer> stack, int item) {

        if (stack.isEmpty() || stack.peek() < item) {
            stack.push(item);
            return;
        }

        int popped = stack.pop();
        sortStackUsingRecursionUtil(stack, item);
        stack.push(popped);
    }
}
