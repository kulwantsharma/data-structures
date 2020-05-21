package main.java;

public final class PrintSubsetOfGivenSize {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5};
        int r = 3;
        printAllSubsetsUsingRecursion(arr, new int[r], r, 0, 0);
    }

    private static void printAllSubsetsUsingRecursion(int[] arr, int[] subset, int r, int index, int i) {

        if (index == r) {
            for (int j = 0; j < r; j++) {
                System.out.print(subset[j] + " ");
            }
            System.out.println();
            return;
        }

        if (i >= arr.length) {
            return;
        }

        printAllSubsetsUsingRecursion(arr, subset, r, index, i + 1);
        subset[index] = arr[i];
        printAllSubsetsUsingRecursion(arr, subset, r, index + 1, i + 1);

    }
}
