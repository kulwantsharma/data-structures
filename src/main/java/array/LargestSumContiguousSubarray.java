package main.java.array;

public final class LargestSumContiguousSubarray {
    public static void main(String[] args) {

        int[] arr = {-2, -3, 4, -1, -2, 1, 5, -3};

        int largestSum = getLargestSum(arr);

        System.out.println("Largest Sum:" + largestSum);

    }

    private static int getLargestSum(int[] arr) {

        int currentMax = 0;
        int maxSum = 0;
        for (int i = 0; i < arr.length; i++) {
            currentMax += arr[i];
            if (currentMax < 0) {
                currentMax = 0;
            }
            if (maxSum < currentMax) {
                maxSum = currentMax;
            }
        }
        return maxSum;
    }
}
