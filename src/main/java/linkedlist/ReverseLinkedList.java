package main.java.linkedlist;

public final class ReverseLinkedList {
    public static void main(String[] args) {

        Node head = MyList.getList();

        System.out.println("Before Reverse");
        MyList.printList();

        head = reverseList(head);

        System.out.println("After Reverse");
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }

        head = MyList.getList();

        head = recursiveReverse(head, null);

        System.out.println("\nAfter Recursive Reverse");
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }


    }

    private static Node recursiveReverse(Node current, Node prev) {

        if (current == null) return prev;

        Node next = current.next;
        current.next = prev;

        return recursiveReverse(next, current);

    }

    private static Node reverseList(Node head) {

        Node current, next, prev = null;

        current = head;

        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }
}
