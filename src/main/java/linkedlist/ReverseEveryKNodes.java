package main.java.linkedlist;

import java.util.Stack;

//https://www.geeksforgeeks.org/reverse-linked-list-groups-given-size-set-2/
public final class ReverseEveryKNodes {
    public static void main(String[] args) {

        //Input : 1->2->3->4->5->6->7->8->9->NULL and k = 3
        //Output : 3->2->1->4->5->6->9->8->7->NULL.


        Node head = MyList.getList();
        MyList.printList(head);

//        System.out.println("After Reverse");
//        head = reverseEveryKNodes(head, 3);
//        System.out.println("Reversed");
//        MyList.printList(head);


        System.out.println("Reverse using Stack");
        head = reverseEveryKNodesUsingStack(head, 3);
        MyList.printList(head);
        System.out.println();

    }

    private static Node reverseEveryKNodesUsingStack(Node head, int k) {

        Stack<Node> stack = new Stack<>();
        Node newHead = null, ptr = null;

        while (head != null) {
            int i = 0;
            while (i < k && head != null) {
                stack.push(head);
                head = head.next;
                i++;
            }
            while (!stack.isEmpty()) {
                if (newHead == null) {
                    newHead = stack.pop();
                    ptr = newHead;
                } else {
                    ptr.next = stack.pop();
                    ptr = ptr.next;
                }
            }

        }
        ptr.next = null;
        return newHead;

    }

    private static Node reverseEveryKNodes(Node head, int k) {

        if (head == null) {
            return null;
        }

        int i = 0;
        Node current = head, next, prev = null;
        while (i < k && current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            i++;
        }
        head.next = reverseEveryKNodes(current, k);
        return prev;

    }
}
