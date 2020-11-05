package array;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {

        int arr[] = {10, 3, 12, 4, 2, 9, 13, 0, 8, 11, 1, 7, 5, 6};

        printNGE(arr);
    }

    private static void printNGE(int arr[]) {

        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while (i < arr.length) {

            if (stack.isEmpty() || stack.peek() > arr[i]) {
                stack.push(arr[i]);
            } else {
                while (!stack.isEmpty() && stack.peek() < arr[i]) {
                     System.out.println("Element:" + stack.pop() + " NGE:" + arr[i]);

                }
                stack.push(arr[i]);

            }

            i++;
        }

        while (!stack.isEmpty()) {
            System.out.println("Element:" + stack.pop() + " NGE:" + -1);
        }


    }
}