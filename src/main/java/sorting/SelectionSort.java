package main.java.sorting;

public final class SelectionSort {
    public static void main(String[] args) {

        int[] arr = {8, 5, 4, 1, 2, 10, 3, 9, 6, 7};

        selectionSort(arr);
        System.out.println("After Selection Sort");
        for (int x : arr) {
            System.out.print(x + " ");
        }


    }

    private static void selectionSort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }

    }
}
