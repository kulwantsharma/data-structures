package main.java.array;

//https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
public final class FindPositionInSortedInfiniteArray {

    public static void main(String[] args) {

        int[] arr = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170, 300, 1000, 4000, 5000, 100000, 200000, 300000};

        int key = 1000;
        int position = findPosition(arr, key);

        System.out.println("Position:" + position);


    }

    private static int findPosition(int[] arr, int key) {

        int low = 0, high = 1;

        while (arr[high] < key) {
            low = high;
            high *= 2;
        }

        return binarySearch(arr, low, high, key);
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
