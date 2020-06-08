package main.java.array;

public final class PairWithGivenSumInSortedAndRotatedArray {
    public static void main(String[] args) {

        int arr[] = {11, 15, 6, 8, 9, 10};

        int minIndex = MinimumElementInSortedAndRotatedArray.findMinimumElement(arr);
        int sum = 26;
        boolean sumExists = doesSumExists(arr, minIndex, sum);
        System.out.println("Sum Exists:" + sumExists);

    }

    private static boolean doesSumExists(int[] arr, int minIndex, int sum) {

        int smaller = minIndex;
        int larger = (minIndex - 1) % arr.length;

        while (smaller != larger) {

            if (sum == arr[smaller] + arr[larger]) return true;

            if (sum > arr[smaller] + arr[larger]) {
                smaller = (smaller + 1) % arr.length;
            } else {
                larger = (arr.length + larger - 1) % arr.length;
            }

        }
        return false;
    }
}
