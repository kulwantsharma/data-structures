package array;

import java.util.HashSet;

public class PrintCombination {
    public static void main(String[] args) {

        int d = 4, n = 3;

        printCombination(d, n);

    }

    private static void printCombination(int d, int n) {

        printCombinationUtil(d, n, "", new HashSet<>());

    }

    private static void printCombinationUtil(int d, int n, String output, HashSet<String> hashSet) {

        if (n == 0) {
            if (!hashSet.contains(output)) {
                System.out.println(output);
                hashSet.add(output);
            }
            return;
        }

        printCombinationUtil(d - 1, n - 1, output + String.valueOf(d) + " ", hashSet);
        printCombinationUtil(d + 1, n - 1, output + String.valueOf(d) + " ", hashSet);

    }
}
