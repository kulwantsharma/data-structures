package linkedlist;

//https://www.geeksforgeeks.org/merge-k-sorted-linked-lists/
public class MergeKSortedLinkedList {
    public static void main(String[] args) {

//        list1 = 1->3->5->7->NULL
//        list2 = 2->4->6->8->NULL
//        list3 = 0->9->10->11->NULL

        Node list1 = new Node(1);
        list1.next = new Node(3);
        list1.next.next = new Node(5);
        list1.next.next.next = new Node(7);


        Node list2 = new Node(2);
        list2.next = new Node(4);
        list2.next.next = new Node(6);
        list2.next.next.next = new Node(8);

        Node list3 = new Node(0);
        list3.next = new Node(9);
        list3.next.next = new Node(10);
        list3.next.next.next = new Node(11);
        list3.next.next.next.next = new Node(14);
        list3.next.next.next.next.next = new Node(19);
        list3.next.next.next.next.next.next = new Node(30);

        int k = 3;
        Node arr[] = new Node[k];
        arr[0] = list1;
        arr[1] = list2;
        arr[2] = list3;

//        Node list = mergeKLists(arr);
        Node list = mergeKListsRecursive(arr);

        System.out.println("After merging");

        while (list != null) {
            System.out.print(list.data + " ");
            list = list.next;
        }

    }

    private static Node mergeKListsRecursive(Node[] arr) {

        for (int i = arr.length - 1; i > 0; i--) {
            arr[i - 1] = mergeKListsRecursiveUtil(arr[i], arr[i - 1]);
        }
        return arr[0];
    }

    private static Node mergeKListsRecursiveUtil(Node list1, Node list2) {

        if (list1 == null) return list2;
        if (list2 == null) return list1;

        Node min = null;
        if (list1.data < list2.data) {
            min = list1;
            list1 = list1.next;
        } else {
            min = list2;
            list2 = list2.next;
        }
        min.next = mergeKListsRecursiveUtil(list1, list2);
        return min;
    }

    private static Node mergeKLists(Node[] arr) {


        Node sorted = null, ptr = null;
        int minIndex;
        int totalLists = arr.length;
        while (totalLists > 1) {

            minIndex = 0;
            for (int i = 1; i < totalLists; i++) {

                if (arr[minIndex].data > arr[i].data) {
                    minIndex = i;
                }
            }

            if (sorted == null) {
                sorted = ptr = arr[minIndex];
            } else {
                ptr.next = arr[minIndex];
                ptr = ptr.next;
            }
            arr[minIndex] = arr[minIndex].next;

            if (arr[minIndex] == null) {
                arr[minIndex] = arr[totalLists - 1];
                totalLists--;
            }
        }

        ptr.next = arr[0];

        return sorted;
    }
}
