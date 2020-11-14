package linkedlist;

//https://www.geeksforgeeks.org/reverse-alternate-k-nodes-in-a-singly-linked-list/
public final class ReverseAlternateKNodes {
    public static void main(String[] args) {

        //Input : 1->2->3->4->5->6->7->8->9->NULL and k = 3
        //Output : 3->2->1->4->5->6->9->8->7->NULL.


        Node head = MyList.getList();
        MyList.printList(head);

        System.out.println("After Reverse");
        head = reverseAlternateKNodes(head, 3);
        System.out.println("Reversed");
        MyList.printList(head);

    }

    private static Node reverseAlternateKNodes(Node head, int k) {

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
        i = 0;
        head.next = current;
        while (i < k && current != null) {
            prev = current;
            current = current.next;
            i++;
        }

        prev.next = reverseAlternateKNodes(current, k);
        return prev;

    }
}
