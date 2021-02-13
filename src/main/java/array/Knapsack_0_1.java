package array;

public class Knapsack_0_1 {
    public static void main(String[] args) {


        int weight[] = {1, 2, 3, 4, 7, 8};
        int value[] = {20, 5, 10, 25, 15, 40};
        int totalWeight = 10;


//        int value[] = {60, 100, 120};
//        int weight[] = {10, 20, 30};
//        int totalWeight = 50;

        System.out.println("Max Value:" + getMaximumValue(weight, value, totalWeight));
    }

    private static int getMaximumValue(int[] weight, int[] value, int totalWeight) {

        int dp[][] = new int[weight.length + 1][totalWeight + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {

                if (j < weight[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], value[i - 1] + dp[i - 1][j - weight[i - 1]]);
                }

            }
        }
        return dp[weight.length][totalWeight];
    }
}
