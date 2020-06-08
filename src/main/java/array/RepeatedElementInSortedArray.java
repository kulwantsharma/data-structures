package main.java.array;

//https://www.geeksforgeeks.org/find-repeating-element-sorted-array-size-n/
public final class RepeatedElementInSortedArray {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 9};

        int repeatedElement = findRepeatedElement(arr, 0, arr.length - 1);

        System.out.println("repeatedElement:" + repeatedElement);

    }

    private static int findRepeatedElement(int[] arr, int low, int high) {

//        if (low > high) {
//            return -1;
//        }

        int mid = low + (high - low) / 2;

        if (mid - 1 >= low && mid + 1 <= high) {
            if (arr[mid - 1] == arr[mid] || arr[mid] == arr[mid + 1]) {
                return arr[mid];
            }
        }
        if (arr[mid] == mid) {
            return findRepeatedElement(arr, low, mid);
        } else {
            return findRepeatedElement(arr, mid, high);
        }
    }
}
