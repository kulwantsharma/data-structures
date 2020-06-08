package main.java.array;

public final class SearchInSortedRotatedArray {
    public static void main(String[] args) {

//        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        int[] arr = {8, 9, 10, 1, 2, 3, 4, 5, 6, 7};
        int[] arr = {4, 5, 6, 7, 8, 9, 10, 1, 2, 3};

//        int key = 8;

        for (int i = 0; i < arr.length; i++) {
            int key = arr[i];
            int index = search(arr, 0, arr.length - 1, key);
            System.out.println("Key:" + key + " Index:" + index);
        }

//        int index = search(arr, 0, arr.length - 1, 1);
//        System.out.println("Index:" + index);

    }

    private static int search(int[] arr, int low, int high, int key) {

        if (low > high) return -1;

        int mid = low + (high - low) / 2;

        if (key == arr[mid]) return mid;

        if (arr[mid] >= arr[low]) {

            if (key >= arr[low] && key <= arr[mid]) {
                return search(arr, low, mid - 1, key);
            } else {
                return search(arr, mid + 1, high, key);
            }

        } else {
            if (key >= arr[mid] && key <= arr[high]) {
                return search(arr, mid + 1, high, key);
            } else {
                return search(arr, low, mid - 1, key);
            }
        }

    }
}
