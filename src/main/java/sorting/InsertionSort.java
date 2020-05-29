package main.java.sorting;

public final class InsertionSort {
    public static void main(String[] args) {

        int arr[] = {8, 9, 10, 3, 5, 4, 1, 2, 6, 7};

        insertionSort(arr);
        System.out.println("After Insertion Sort");
        for (int x : arr) {
            System.out.print(x + " ");
        }

    }

    private static void insertionSort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {

            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    break;
                }
            }

        }


    }
}
