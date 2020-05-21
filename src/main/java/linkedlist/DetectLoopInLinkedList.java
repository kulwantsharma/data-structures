package main.java.linkedlist;

import java.util.HashSet;

public final class DetectLoopInLinkedList {

    public static void main(String[] args) {

        Node head = MyList.getList();


        printList(head);

        //creating loop
        head.next.next.next.next.next.next.next = head.next;

        System.out.println(detectLoop(head));

        System.out.println(detectLoopUsingHashMap(head));
    }


    // Using floyd circle finding algorithm or tortoise-hair algorithm
    public static boolean detectLoop(Node head) {

        Node slow, fast;
        slow = fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }

        return false;
    }


    private static boolean detectLoopUsingHashMap(Node head) {

        HashSet<Node> hashSet = new HashSet<>();
        while (head != null) {
            if (hashSet.contains(head)) {
                return true;
            }
            hashSet.add(head);
            head = head.next;
        }
        return false;
    }

    private static void printList(Node head) {

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }


}
