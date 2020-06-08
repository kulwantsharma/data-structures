package main.java.array;

//https://www.geeksforgeeks.org/find-index-first-1-infinite-sorted-array-0s-1s/
public final class IndexOf1InInfiniteArray {
    public static void main(String[] args) {

        // I have assumed array is finite
//        int[] arr = {0, 0, 1, 1, 1, 1};
//        int[] arr = {1,1,1,1,1,1,1,1,1,1, 1, 1, 1, 1};
        int[] arr = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1};

        int index = findIndex(arr);

        System.out.println("Index:" + index);

    }

    private static int findIndex(int[] arr) {

        if (arr[0] == 1) return 0;

        return findIndexUtil(arr, 0, arr.length);

    }

    private static int findIndexUtil(int[] arr, int low, int high) {

        int mid = low + (high - low) / 2;

        if (arr[mid] == 1 && arr[mid - 1] == 0) return mid;

        else if (arr[mid] == 1) return findIndexUtil(arr, low, mid - 1);

        else return findIndexUtil(arr, mid + 1, high);

    }
}
