package main.java.array;

public class FirstOccuranceOfNumber {
    public static void main(String[] args) {

        int arr[] = {10, 20, 20, 20, 20, 30, 30, 30, 40, 50, 60, 70, 90};


//        int key = 50;

        for (int i = 0; i < arr.length; i++) {
            int key = arr[i];
            int index = findFirstOccuranceOfX(arr, 0, arr.length - 1, key);
            System.out.println("Index:" + index);
        }


    }

    private static int findFirstOccuranceOfX(int[] arr, int low, int high, int key) {

        if (low > high) return -1;

        int mid = low + (high - low) / 2;

        if (mid == low && arr[mid] == key || mid == high && arr[mid] == key) {
            return mid;
        }

        if (arr[mid] >= key) {
            return findFirstOccuranceOfX(arr, low, mid, key);
        } else {
            return findFirstOccuranceOfX(arr, mid + 1, high, key);
        }

    }
}
