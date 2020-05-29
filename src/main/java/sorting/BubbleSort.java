package main.java.sorting;

public final class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {8, 5, 4, 1, 2, 10, 3, 9, 6, 7};

        bubbleSort(arr);
        System.out.println("After Bubble Sort");
        for (int x : arr) {
            System.out.print(x + " ");
        }


    }

    private static void bubbleSort(int[] arr) {

        for (int i = arr.length; i > 0; i--) {
            boolean flag = false;
            for (int j = 0; j < i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }

            }
            if (!flag) {
                //since no swap so break;
                break;
            }
        }

    }
}
