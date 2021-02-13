package array;


import java.util.Arrays;

public class CoinChangingProblem {
    public static void main(String[] args) {

//        int coins[] = {25, 10, 5};
//        int total = 30;

        int coins[] = {1, 5, 6, 8};
        int total = 20;
//        int[] coins = {9, 2, 11, 5, 14, 17, 8, 18};
//          int coins[] = {2, 5, 8, 9, 11, 14, 17, 18};
//        int coins[] = {5, 17};
//        int total = 39;


//        int coins[] = {1, 4, 5};
//        int total = 13;
        System.out.println(minCoins(coins, coins.length, total));
        System.out.println(getMinimumCoins(coins, total));
    }

    public static int minCoins(int[] coins, int size, int total) {
        Arrays.sort(coins);
        int[][] dp = new int[coins.length][total + 1];

        // Fill first row
        for (int i = 0; i < total + 1; i++) {
            if (i % coins[0] == 0) {
                dp[0][i] = i / coins[0];
            } else {
                dp[0][i] = -1;
            }
        }

        // filling rest of the row

        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j < total + 1; j++) {

                if (j == coins[i]) {
                    dp[i][j] = 1;
                } else if (j < coins[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {

                    if (dp[i][j - coins[i]] != -1 && dp[i - 1][j] != -1) {
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i]] + 1);
                    } else {

                        if (dp[i][j - coins[i]] > -1) {
                            dp[i][j] = dp[i][j - coins[i]] + 1;
                        } else {
                            dp[i][j] = dp[i - 1][j];
                        }
                    }
                }
            }
        }


        return dp[coins.length - 1][total];
    }

    private static int getMinimumCoins(int[] coins, int total) {

        int[] dp = new int[total + 1];

        for (int i = 1; i <= total; i++) {
            dp[i] = Integer.MAX_VALUE - 1;
        }

        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= total; j++) {
                if (j >= coins[i]) {
                    if (dp[j] > dp[j - coins[i]]) {
                        dp[j] = dp[j - coins[i]] + 1;
                    }
                }
            }
        }
        return dp[total];
    }



    /*
     public static int minCoins(int[] coins, int size, int total) {
        Arrays.sort(coins);
        int[][] dp = new int[coins.length][total + 1];

        // Fill first row
        for (int i = 0; i < total + 1; i++) {
            if (i % coins[0] == 0) {
                dp[0][i] = i / coins[0];
            } else {
                dp[0][i] = -1;
            }
        }

        // filling rest of the row

        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j < total + 1; j++) {

                if (j == coins[i]) {
                    dp[i][j] = 1;
                } else if (j < coins[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {

                    if (dp[i][j - coins[i]] != -1 && dp[i - 1][j] != -1) {
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - coins[i]] + 1);
                    } else {

                        if (dp[i][j - coins[i]] > -1) {
                            dp[i][j] = dp[i][j - coins[i]] + 1;
                        } else {
                            dp[i][j] = dp[i - 1][j];
                        }
                    }
                }
            }
        }


        return dp[coins.length - 1][total];
    }
     */


}
