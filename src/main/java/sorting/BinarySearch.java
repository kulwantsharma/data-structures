package main.java.sorting;

public final class BinarySearch {
    public static void main(String[] args) {

//        int[] arr = {3, 5, 7, 9, 10, 90,
//                100, 130, 140, 160, 170};

        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

        int key = 21;
        int index = binarySearch(arr, 0, 19, key);
        System.out.println("Element Index:" + index);

    }

    private static int binarySearch(int[] arr, int low, int high, int key) {

        if (low > high) return -1;

        int mid = low + (high - low) / 2;

        if (arr[mid] == key) return mid;

        else if (arr[mid] > key) {
            return binarySearch(arr, low, mid - 1, key);
        } else {
            return binarySearch(arr, mid + 1, high, key);
        }

    }
}
