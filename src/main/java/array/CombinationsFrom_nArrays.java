package array;

//https://www.geeksforgeeks.org/combinations-from-n-arrays-picking-one-element-from-each-array/
public class CombinationsFrom_nArrays {
    public static void main(String[] args) {

//        int[][] arr = {{1}, {2, 3, 4}, {5}};
        int[][] arr = {{1, 2, 3}, {4}, {5, 6}};

        printCombination(arr, 0, "");

    }

    private static void printCombination(int[][] arr, int level, String combination) {

        if (level == arr.length) {
            System.out.println(combination);
            return;
        }
        for (int i = 0; i < arr[level].length; i++) {
            printCombination(arr, level + 1, combination + arr[level][i] + " ");
        }


    }
}
