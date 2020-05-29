package main.java.sorting;

public final class MergeSort {
    public static void main(String[] args) {

        int arr[] = {8, 9, 10, 3, 5, 4, 1, 2, 6, 7};
        mergeSort(arr, 0, arr.length - 1);
//
//
//        int arr[] = {1, 3, 5, 7, 9, 2, 4, 6, 8, 10};
//        merge(arr, 0, 4, 5, 9);
        System.out.println("After Merge Sort");
        for (int x : arr) {
            System.out.print(x + " ");
        }

    }

    public static void mergeSort(int[] arr, int low, int high) {

        if (high > low) {

            int mid = low + (high - low) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, mid + 1, high);
        }

    }

    private static void merge(int[] arr, int low1, int high1, int low2, int high2) {

        int temp[] = new int[high2 - low1 + 1];
        int j = 0;
        int k = low1;
        while (high1 >= low1 && high2 >= low2) {
            if (arr[low1] < arr[low2]) {
                temp[j++] = arr[low1++];
            } else {
                temp[j++] = arr[low2++];
            }
        }

        if (low1 > high1) {
            while (high2 >= low2) {
                temp[j++] = arr[low2++];
            }
        }
        if (low2 > high2) {
            while (high1 >= low1) {
                temp[j++] = arr[low1++];
            }
        }

        for (int i = 0; i < temp.length; i++) {
            arr[k++] = temp[i];
        }

    }
}
