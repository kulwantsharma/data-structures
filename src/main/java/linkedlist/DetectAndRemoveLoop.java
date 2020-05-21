package main.java.linkedlist;

public final class DetectAndRemoveLoop {
    public static void main(String[] args) {

        Node head = MyList.getList();

        //creating loop
        head.next.next.next.next.next.next.next = head.next.next.next.next;

        Node slowPointer = detectLoop(head);

        if (slowPointer != null) {
            System.out.println("Loop Detected");
            removeLoop(head, slowPointer);
            MyList.printList();
        } else {
            System.out.println("Loop doesn't exist");
        }

    }

    private static Node detectLoop(Node head) {
        Node slow, fast;
        slow = fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return slow;
        }

        return null;
    }

    private static void removeLoop(Node head, Node slow) {

        Node prev = null;
        while (head != slow) {

            prev = slow;
            head = head.next;
            slow = slow.next;

        }
        System.out.println("Loop Removed");
        prev.next = null;
    }
}
