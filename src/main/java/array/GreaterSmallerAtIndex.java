package main.java.array;

//https://www.geeksforgeeks.org/find-the-element-before-which-all-the-elements-are-smaller-than-it-and-after-which-all-are-greater-than-it/
public final class GreaterSmallerAtIndex {
    public static void main(String[] args) {

//        int[] arr = {5, 1, 4, 3, 6, 8, 10, 7, 9};
//        int arr[] = {5, 1, 4, 4};
        int arr[] = {3, 10, 10};

        int index = getIndex(arr);

        System.out.println("Index:" + index);

    }

    private static int getIndex(int[] arr) {

        int[] smaller = new int[arr.length];
        int[] greater = new int[arr.length];

        smaller[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < smaller[i - 1]) {
                smaller[i] = smaller[i - 1];
            } else {
                smaller[i] = arr[i];
            }
        }

        for (int x : smaller) {
            System.out.print(x + " ");
        }

        greater[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] < greater[i + 1]) {
                greater[i] = arr[i];
            } else {
                greater[i] = greater[i + 1];
            }
        }

        System.out.println();
        for (int x : greater) {
            System.out.print(x + " ");
        }

        System.out.println();
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] >= smaller[i - 1] && arr[i] <= greater[i + 1]) {
                return i;
            }
        }
        return -1;
    }
}
