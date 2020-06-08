package main.java.array;

public final class MinimumElementInSortedAndRotatedArray {
    public static void main(String[] args) {

//        int[] arr = {5, 6, 7, 8, 9, 10, 2, 3, 4};
//        int[] arr = {9, 10, 2, 3, 4, 5, 6, 7, 8};
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};


//        int minElement = findMinimumElement(arr);
//        System.out.println("Minimum Element:" + minElement);

        int maxElementIndex = findMaximumElement(arr);
        System.out.println("MaxIndex:" + arr[maxElementIndex]);

    }


    public static int findMinimumElement(int[] arr) {
        if (arr[0] <= arr[arr.length - 1]) return arr[0];
        return findMinimumElementUtil(arr, 0, arr.length - 1);
    }

    private static int findMinimumElementUtil(int[] arr, int low, int high) {

        if (low > high) return -1;


        int mid = low + (high - low) / 2;

        if (mid + 1 < arr.length && arr[mid] > arr[mid + 1]) return mid + 1;
        if (mid - 1 >= 0 && arr[mid - 1] > arr[mid]) return mid;

        if (arr[low] > arr[mid]) {
            return findMinimumElementUtil(arr, low, mid - 1);
        } else {
            return findMinimumElementUtil(arr, mid + 1, high);
        }

    }


    private static int findMaximumElement(int[] arr) {

        if (arr[arr.length - 1] > arr[0]) return arr.length - 1;

        return findMaximumElementUtil(arr, 0, arr.length - 1);

    }

    private static int findMaximumElementUtil(int[] arr, int low, int high) {

        if (low > high) return -1;

        int mid = low + (high - low) / 2;

        if (mid + 1 < arr.length && arr[mid] > arr[mid + 1]) {
            return mid;
        }
        if (arr[low] > arr[mid]) {
            return findMaximumElementUtil(arr, low, mid - 1);
        } else {
            return findMaximumElementUtil(arr, mid + 1, high);
        }


    }

}
