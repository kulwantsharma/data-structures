package main.java.sorting;

public final class QuickSort {
    public static void main(String[] args) {
        int[] arr = {8, 5, 4, 1, 2, 10, 3, 9, 6, 7};

        quickSort(arr, 0, arr.length - 1);
        System.out.println("After Quick Sort");
        for (int x : arr) {
            System.out.print(x + " ");
        }

    }

    public static void quickSort(int[] arr, int low, int high) {

        if (high > low) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {

        int pivot = high;
        int i = low - 1;
        for (int j = low; j <= high; j++) {
            if (arr[j] <= arr[pivot]) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

        return i;
    }
}
