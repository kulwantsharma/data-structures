package array;

public class MaximizeProfit {
    public static void main(String[] args) {

        int arr[] = {10, 8, 6, 4, 2, 4, 6, 2, 4};

        System.out.println(getMaxProfit(arr));

    }

    private static int getMaxProfit(int[] arr) {

        int maxProfit = 0;
        int currentMax = 0;
        int start = 0;
        int startDay = 0, endDay = 0;
        for (int i = 1; i < arr.length; i++) {

            if (arr[i] > arr[i - 1]) {
                currentMax = currentMax + arr[i] - arr[i - 1];

                if (maxProfit < currentMax) {
                    maxProfit = currentMax;
                    startDay = start;
                    endDay = i;
                }
            } else {
                currentMax = 0;
                start = i;
            }
        }
        System.out.println("start:" + startDay + " end:" + endDay);
        return maxProfit;
    }
}
