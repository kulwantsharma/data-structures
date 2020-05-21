package main.java.array;

// Does there exist a set with the given sum.
public final class SubsetSumProblem {

    public static void main(String[] args) {

        int[] set = {3, 34, 4, 12, 5, 2};
//        int[] set = {3, 4, 5, 2};

        int sum = 30;

//        System.out.println(doesSumExistsRecursive(set, sum, 0));
//        System.out.println(k);
        System.out.println("\nDoes Sum Exists::" + doesSumExistsDynamicProgramming(set, sum));

    }

    private static boolean doesSumExistsDynamicProgramming(int[] set, int sum) {

        boolean[][] subset = new boolean[set.length + 1][sum + 1];

        for (int i = 0; i <= set.length; i++) {
            subset[i][0] = true;
        }
        for (int i = 1; i <= sum; i++) {
            subset[0][i] = false;
        }


        for (int i = 1; i <= set.length; i++) {
            for (int j = 1; j <= sum; j++) {

                if (j < set[i - 1]) {
                    subset[i][j] = subset[i - 1][j];
                } else {

                    if (j == set[i - 1]) {
                        subset[i][j] = true;
                    } else {
                        if (subset[i - 1][j]) {
                            subset[i][j] = subset[i - 1][j];
                        } else {
                            subset[i][j] = subset[i - 1][j - set[i - 1]];
                        }
                    }

                }

            }
        }


        return subset[set.length][sum];
    }

    private static boolean doesSumExistsRecursive(int[] set, int sum, int index) {
        if (sum == 0) {
            return true;
        }
        if (sum < 0 || index == set.length) {
            return false;
        }
        return doesSumExistsRecursive(set, sum, index + 1) || doesSumExistsRecursive(set, sum - set[index], index + 1);
    }
}
