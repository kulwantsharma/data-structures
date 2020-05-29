package main.java.sorting;

public final class HeapSort {
    public static void main(String[] args) {
        int arr[] = {8, 9, 10, 3, 5, 4, 1, 2, 6, 7};

        heapSort(arr);
        System.out.println("After heap Sort");
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }

    public static void heapSort(int[] arr) {

        buildHeap(arr);

        for (int i = arr.length; i > 0; i--) {
            heapify(arr, 0, i);

            int temp = arr[0];
            arr[0] = arr[i - 1];
            arr[i - 1] = temp;
        }

    }

    public static void buildHeap(int[] arr) {

        int lastNonLeafIndex = arr.length / 2;

        for (int i = lastNonLeafIndex; i >= 0; i--) {
            heapify(arr, i, arr.length);
        }

    }

    private static void heapify(int[] arr, int index, int length) {

        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;

        int maxIndex = index;

        if (leftChildIndex < length && arr[leftChildIndex] > arr[maxIndex]) {
            maxIndex = leftChildIndex;
        }
        if (rightChildIndex < length && arr[rightChildIndex] > arr[maxIndex]) {
            maxIndex = rightChildIndex;
        }

        if (maxIndex != index) {
            int temp = arr[maxIndex];
            arr[maxIndex] = arr[index];
            arr[index] = temp;
            heapify(arr, maxIndex, length);
        }
    }
}
