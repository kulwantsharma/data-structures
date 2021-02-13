package array;

//https://practice.geeksforgeeks.org/problems/maximum-no-of-1s-row3027/1
public class MaximumNoOf1sRow {
    public static void main(String[] args) {

        int[][] arr = {{0, 0, 0, 1},
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 0, 0, 0}};

        System.out.println("Maximum No Of 1s Row:" + findMaxNoOf1sRow(arr));


//        int test[] = {0, 0, 0, 0, 0};
//        System.out.println(getMinIndexOf1(test, 0, test.length-1));


    }

    private static int findMaxNoOf1sRow(int[][] arr) {

        int minIndexSoFar = Integer.MAX_VALUE;
        int resultantRow = 0;

        for (int i = 0; i < arr.length; i++) {

            int minIndex = getMinIndexOf1(arr[i], 0, arr[i].length - 1);
            if (minIndex != -1 && minIndexSoFar > minIndex) {
                minIndexSoFar = minIndex;
                resultantRow = i;
            }

        }

        return resultantRow;
    }


    private static int getMinIndexOf1(int[] arr, int low, int high) {

        if (high >= low) {

            if (arr[low] == 1) {
                return low;
            }

            int mid = low + (high - low) / 2;

            if (mid - 1 >= low && arr[mid - 1] == 0 && arr[mid] == 1) {
                return mid;
            }

            if (arr[mid] == 0) {
                return getMinIndexOf1(arr, mid + 1, high);
            } else {
                return getMinIndexOf1(arr, low, mid - 1);
            }
        }

        return -1;

    }
}
