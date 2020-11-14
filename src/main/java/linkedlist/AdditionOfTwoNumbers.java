package linkedlist;

public class AdditionOfTwoNumbers {
    public static void main(String[] args) {

        //7->5->9->4->6
        Node l1 = new Node(7);
        l1.next = new Node(5);
        l1.next.next = new Node(9);
        l1.next.next.next = new Node(4);
        l1.next.next.next.next = new Node(6);


        //8->4
        Node l2 = new Node(8);
        l2.next = new Node(4);

        Node l3 = sum(l1, l2);

        print(l3);

    }

    private static void print(Node list) {

        while (list != null) {
            System.out.print(list.data + " ");
            list = list.next;
        }

    }

    private static Node sum(Node l1, Node l2) {

        Node result = null;
        Node ptr = null;

        int carry = 0;
        while (l1 != null || l2 != null) {

            int sum = (l1 == null ? 0 : l1.data) + (l2 == null ? 0 : l2.data) + carry;
            carry = sum / 10;

            if (result == null) {
                result = new Node(sum % 10);
                ptr = result;
            } else {
                ptr.next = new Node(sum % 10);
                ptr = ptr.next;
            }

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;

        }
        return result;
    }
}
