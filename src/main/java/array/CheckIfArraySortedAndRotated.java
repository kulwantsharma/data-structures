package main.java.array;

public final class CheckIfArraySortedAndRotated {
    public static void main(String[] args) {

//        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        int[] arr = {8, 9, 10, 1, 2, 3, 4, 5, 6, 7};
//        int[] arr = {4, 5, 6, 7, 8, 9, 10, 1, 2, 3};
        int[] arr = {10, 9, 8, 1, 2, 3};

        System.out.println(checkIfArraySortedAndRotated(arr));
    }

    private static boolean checkIfArraySortedAndRotated(int[] arr) {

        int i = 1;

        while (i < arr.length && arr[i - 1] < arr[i]) {
            i++;
        }

        if (i == arr.length) return false;
        i++;

        while (i < arr.length && arr[i - 1] < arr[i]) {
            i++;
        }

        if (i != arr.length) return false;

        return true;

    }
}
