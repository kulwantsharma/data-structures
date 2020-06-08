package main.java.array;

//https://www.geeksforgeeks.org/find-first-and-last-positions-of-an-element-in-a-sorted-array/
public final class FindFirstLastIndex {
    public static void main(String[] args) {

//        int arr[] = {1, 3, 5, 5, 5, 5, 67, 123, 125};
//        int key = 5;
//
//        int arr[] = {2, 8, 8, 8, 8, 8, 8, 8, 8};
//        int key = 2;

//        int arr[] = {1,1,1,1,1,1,1,1,1,1,2};
//        int key = 2;

        int arr[] = {1, 2, 2, 2, 2, 3, 4, 7, 8, 8};
        int key = 8;

        int leftIndex = getLeftIndex(arr, 0, arr.length - 1, key);
        int rightIndex = getRightIndex(arr, 0, arr.length - 1, key);

        System.out.println("LeftIndex:" + leftIndex);
        System.out.println("RightIndex:" + rightIndex);

    }

    private static int getLeftIndex(int[] arr, int low, int high, int key) {

        if (low > high) return -1;

        int mid = low + (high - low) / 2;

        if (mid == low && arr[mid] == key || mid == high && arr[mid] == key) {
            return mid;
        }

        if (arr[mid] >= key) {
            return getLeftIndex(arr, low, mid, key);
        } else {
            return getLeftIndex(arr, mid + 1, high, key);
        }

    }

    private static int getRightIndex(int[] arr, int low, int high, int key) {

        if (low > high) return -1;

        int mid = low + (high - low) / 2;

        if (mid == high && arr[mid] == key) {
            return mid;
        }
        if (arr[mid] <= key) {
            return getRightIndex(arr, mid + 1, high, key);
        } else {
            return getRightIndex(arr, low, mid - 1, key);
        }

    }
}
