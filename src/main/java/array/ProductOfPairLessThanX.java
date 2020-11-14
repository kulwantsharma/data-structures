package array;

//https://www.geeksforgeeks.org/count-pairs-in-a-sorted-array-whose-product-is-less-than-k/
public final class ProductOfPairLessThanX {
    public static void main(String[] args) {

        int[] arr = {2, 3, 4, 6, 9};
        int k = 20;

        System.out.println("Total Pairs:" + countPairs(arr, k));
    }

    private static int countPairs(int[] arr, int k) {

        int i = 0;
        int j = arr.length - 1;
        int count = 0;
        while (j > i) {
            if (arr[i] * arr[j] < k) {
                count += j - i;
                i++;
            } else {
                j--;
            }
        }
        return count;
    }
}
