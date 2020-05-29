package main.java.array;

//https://www.geeksforgeeks.org/search-element-unsorted-array-using-minimum-number-comparisons/
public final class MinimumNumberOfComparison {
    public static void main(String[] args) {

        int arr[] = {4, 6, 1, 5, 8};

        int key = 5;

        boolean found = search(arr, key);
        System.out.println(found);

    }

    private static boolean search(int[] arr, int key) {

        if (arr[arr.length - 1] == key) return true;

        int backup = arr[arr.length - 1];
        arr[arr.length - 1] = key;

        for (int i = 0; ; i++) {

            if (arr[i] == key) {

                arr[arr.length - 1] = backup;

                if (i < arr.length - 1) {
                    return true;
                }

                return false;

            }

        }


    }

}
