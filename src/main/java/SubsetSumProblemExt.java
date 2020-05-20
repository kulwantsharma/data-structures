package test.furloughPractice;

// Can a set be divided into two sets such that sums are equal. In this case, first add all the numbers of the set
// and check if it is odd number, then set cannot be divided into two sets. If it is even then divide the sum be 2.
// nad now check if the newSum(sum/2) exists in the set.
public class SubsetSumProblemExt {

    public static void main(String[] args) {
        int[] set = {3, 34, 4, 12, 5, 2};

        int sum = 0;
        for (int i = 0; i < set.length; i++) {
            sum += set[i];
        }

        System.out.println("Sum:" + sum);
        if (sum % 2 != 0) {
            System.out.println("The sets cannot be divided into two sets");
        } else {
            System.out.println("\nDoes Sum Exists::" + doesSumExistsDynamicProgramming(set, sum / 2));
        }
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

}
