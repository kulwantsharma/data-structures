package stack;

import java.util.Stack;

public final class QueueUsingStacks {
    public static void main(String[] args) {

        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();

        queue.enqueue(3);
        queue.enqueue(4);

        queue.dequeue();
        queue.dequeue();


    }

    static class Queue {

        private Stack<Integer> stack1 = new Stack<>();
        private Stack<Integer> stack2 = new Stack<Integer>();

        public void enqueue(int x) {
            stack1.push(x);
        }

        public void dequeue() {

            if (stack2.isEmpty()) {

                if (stack1.isEmpty()) {
                    System.out.println("Queue underflow");
                } else {
                    while (!stack1.isEmpty()) {
                        stack2.push(stack1.pop());
                    }
                    System.out.print(stack2.pop() + " ");
                }

            } else {
                System.out.print(stack2.pop() + " ");
            }


        }
    }
}
