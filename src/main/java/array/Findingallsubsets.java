package main.java.array;

import java.util.ArrayList;
import java.util.List;

public final class Findingallsubsets {

    static int k = 0;

    public static void main(String[] args) {
        String set = "abcd";
//        printAllSubsets(set.toCharArray());

//        printAllSubsetsUsingRecursion(set.toCharArray(), 0, "");
//        System.out.println("k:" + k);

        int[] arr = {1, 2, 3, 4};
        List<List<Integer>> lists = printAllSubsetsUsingRecursion(arr);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }

    private static List<List<Integer>> printAllSubsetsUsingRecursion(int[] arr) {

        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        printAllSubsetsUsingRecursionUtil(arr, lists, subset, 0);

        return lists;
    }

    private static void printAllSubsetsUsingRecursionUtil(int[] arr, List<List<Integer>> result, List<Integer> subset,
                                                          int depth) {

        if (depth == arr.length) {
            List<Integer> newSubset = new ArrayList<>(subset);
            result.add(subset);
//            System.out.println(subset);
            return;
        }
        printAllSubsetsUsingRecursionUtil(arr, result, subset, depth + 1);
        subset.add(arr[depth]);
        printAllSubsetsUsingRecursionUtil(arr, result, subset, depth + 1);
        subset.remove(subset.size()-1);

    }

    //    private static void printAllSubsetsUsingRecursion(char[] arr, int depth, String subset) {
//        k++;
//
//        if (depth == arr.length) {
//            System.out.println(subset);
//            return;
//        }
//        printAllSubsetsUsingRecursion(arr,depth+1,subset);
//        printAllSubsetsUsingRecursion(arr,depth+1, subset + arr[depth]);
//    }
//
    private static void printAllSubsets(char[] arr) {

        int subSetSize = (int) Math.pow(2, arr.length);

        for (int i = 0; i < subSetSize; i++) {
            System.out.print("{ ");
            for (int j = 0; j < arr.length; j++) {
                if ((i & 1 << j) != 0) {
                    System.out.print(arr[j] + " ");
                }
            }
            System.out.println("}");
        }

    }
}
