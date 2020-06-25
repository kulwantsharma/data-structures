package main.java.linkedlist;

public final class DeleteOccurrences {
    public static void main(String[] args) {

        Node head = new Node(1);
//        Node head = new Node(2);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);
        head.next.next.next.next = new Node(3);
        head.next.next.next.next.next = new Node(4);
        head.next.next.next.next.next.next = new Node(4);
        head.next.next.next.next.next.next.next = new Node(4);
//        head.next.next.next.next.next.next.next.next = new Node(5);
//        head.next.next.next.next.next.next.next.next.next = new Node(6);

        printList(head);
        System.out.println();

        head = deleteOccurrences(head);

        System.out.println("After Deleting Occurrences");
        printList(head);

    }

    private static Node deleteOccurrences(Node head) {

        Node newHead = null;
        Node ptr = null;
        while (head != null) {
            int nodeToBeDeleted = -1;
            if (head != null && head.next != null && head.data == head.next.data) {
                nodeToBeDeleted = head.data;
            }
            if (nodeToBeDeleted != -1) {
                while (head != null && nodeToBeDeleted == head.data) {
                    head = head.next;
                }
            }
            if (head != null && head.next != null && head.data == head.next.data) {
                continue;
            }
            if (head == null) {
                break;
            }
            if (newHead == null) {
                newHead = head;
                ptr = head;
                head = head.next;
            } else {
                ptr.next = head;
                ptr = ptr.next;
                head = head.next;
            }

        }
        if (ptr != null) {
            ptr.next = null;
        }

        return newHead;
    }

    private static Node deleteNode(Node head, int value) {

//        System.out.println("deleting node:" + value);
        while (head != null && value == head.data) {
//            System.out.println("hello");
            head = head.next;
        }
//        System.out.println("deleted node:" + value);
        return head;
    }

    private static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }
}
