package string;

import java.util.Stack;

//https://practice.geeksforgeeks.org/problems/valid-substring0624/1
public class ValidSubstring {
    public static void main(String[] args) {

        String str = "()(())((()()()())";

        System.out.println(getMaxValidSubstringLength(str));

    }

    private static int getMaxValidSubstringLength(String str) {

        Stack<Integer> stack = new Stack<>();

        stack.push(-1);
        int result = 0;
        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == '(') {

                stack.push(i);

            } else {

                if (!stack.isEmpty()) {
                    stack.pop();
                }

                if (!stack.isEmpty()) {

                    result = Math.max(result, i - stack.peek());

                } else {
                    stack.push(i);
                }

            }

        }
        return result;
    }
}
