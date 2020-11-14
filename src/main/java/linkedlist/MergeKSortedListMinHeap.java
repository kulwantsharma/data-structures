package linkedlist;

//https://www.geeksforgeeks.org/merge-k-sorted-linked-lists-set-2-using-min-heap/
public class MergeKSortedListMinHeap {
    public static void main(String[] args) {

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

        Node head = mergeKSortedList(arr, k);

        printList(head);
    }

    private static Node mergeKSortedList(Node[] arr, int k) {

        Node head = null, ptr = null;
        MinHeap minHeap = new MinHeap(k);
        minHeap.arr[0] = arr[0];
        minHeap.arr[1] = arr[1];
        minHeap.arr[2] = arr[2];

        minHeap.buildHeap();

        while (minHeap.size > 0) {

            Node node = minHeap.extractMin();

            if (head == null) {
                head = ptr = node;
            } else {
                ptr.next = node;
                ptr = ptr.next;
            }

        }
        return head;
    }

    private static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    static class MinHeap {

        Node[] arr;
        int size;

        MinHeap(int size) {
            this.size = size;
            arr = new Node[size];
        }

        public int getMin() {
            return arr[0].data;
        }

        public Node extractMin() {

            Node node = arr[0];

            arr[0] = arr[0].next;

            if (arr[0] == null) {
                arr[0] = arr[size - 1];
                size--;
            }
            heapify(0);
            return node;
        }

        public void buildHeap() {

            int last_non_leaf_index = size / 2;
            for (int i = last_non_leaf_index; i >= 0; i--) {
                heapify(i);
            }

        }

        private void heapify(int index) {

            int leftChildIndex = index * 2 + 1;
            int rightChildIndex = index * 2 + 2;

            int minIndex = index;

            if (leftChildIndex < size && arr[leftChildIndex].data < arr[minIndex].data) {
                minIndex = leftChildIndex;
            }
            if (rightChildIndex < size && arr[rightChildIndex].data < arr[minIndex].data) {
                minIndex = rightChildIndex;
            }

            if (minIndex != index) {
                Node temp = arr[minIndex];
                arr[minIndex] = arr[index];
                arr[index] = temp;
                heapify(minIndex);
            }

        }

    }
}
