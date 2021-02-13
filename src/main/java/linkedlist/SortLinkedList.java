package linkedlist;

//https://www.geeksforgeeks.org/how-to-sort-a-linked-list-that-is-sorted-alternating-ascending-and-descending-orders/
public class SortLinkedList {
    public static void main(String[] args) {

        //10->60->30->40->50->20
        Node head = new Node(10);
        head.next = new Node(60);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        head.next.next.next.next.next = new Node(20);

        System.out.println("Before Sorting");
        printList(head);

        sortList(head);

        System.out.println("\nAfter Sorting");
        printList(head);

    }

    private static void sortList(Node head) {

        Node asc = null;
        Node desc = null;
        Node aNext = null;
        Node dNext = null;

        //Ascending List
        asc = aNext = head;
        head = head.next;

        //Descending List
        desc = dNext = head;
        if (head != null)
            head = head.next;


        while (head != null) {

            aNext.next = head;
            aNext = aNext.next;

            dNext.next = head.next;
            dNext = dNext.next;

            head = head.next;
            if (head != null) {
                head = head.next;
            }
        }
        aNext.next = null;
        dNext.next = null;

        desc = reverseList(desc);

        //Merging two sorted list
        mergeSortedList(asc, desc);

    }

    private static void mergeSortedList(Node l1, Node l2) {

        Node sortedList = l1;
        l1 = l1.next;
        Node ptr = sortedList;

        while (l1 != null && l2 != null) {

            if (l1.data > l2.data) {
                ptr.next = l2;
                ptr = ptr.next;
                l2 = l2.next;
            } else {
                ptr.next = l1;
                ptr = ptr.next;
                l1 = l1.next;
            }

        }

        if (l1 == null) {
            ptr.next = l2;
        } else {
            ptr.next = l1;
        }


    }

    private static Node reverseList(Node head) {

        Node current = head, next = null, prev = null;
        while (current != null) {

            next = current.next;
            current.next = prev;
            prev = current;
            current = next;

        }

        return prev;
    }

    private static void printList(Node head) {

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }

    }
}
