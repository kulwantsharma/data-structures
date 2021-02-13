package linkedlist;

//https://practice.geeksforgeeks.org/problems/sorted-insert-for-circular-linked-list/1
public class SortedInsertCircularLinkedList {
    public static void main(String[] args) {

        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);

        head.next.next.next.next.next = head;

//        printList(head);

        int key = 5;
        head = sortedInsert(head, key);
        printList(head);

        System.out.println();
        key = 25;
        head = sortedInsert(head, key);
        printList(head);

        System.out.println();
        key = 60;
        head = sortedInsert(head, key);
        printList(head);


    }

    private static Node getLastNode(Node head) {

        Node ptr = head;
        Node prev = null;
        do {
            prev = ptr;
            ptr = ptr.next;
        } while (ptr != head);

        return prev;
    }

    private static Node sortedInsert(Node head, int key) {

        Node temp = new Node(key);

        Node prev = null, current = null;

        current = head;

        if (current.data > key) {
            temp.next = current;
            Node lastNode = getLastNode(head);
            lastNode.next = temp;
            return temp;
        }
        boolean flag = false;

        do {

            if (current.data > key) {
                temp.next = current;
                prev.next = temp;
                flag = true;
                break;
            }

            prev = current;
            current = current.next;

        } while (current != head);

        if (!flag) {
            prev.next = temp;
            temp.next = current;
        }

        return head;

    }

    private static void printList(Node head) {

        Node ptr = head;
        do {
            System.out.print(ptr.data + " ");
            ptr = ptr.next;
        } while (ptr != head);

    }
}
