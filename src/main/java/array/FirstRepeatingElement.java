package main.java.array;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class FirstRepeatingElement {
    public static void main(String[] args) {

        int[] arr = {10, 5, 3, 4, 3, 5, 6};
//        int arr[] = {6, 10, 5, 4, 9, 120, 4, 6, 10};


        int firstRepeating = findFirstRepeating(arr);

        System.out.println(firstRepeating);


        findFirstRepeatingElement(arr);

    }

    private static int findFirstRepeating(int[] arr) {

        Map<Integer, Integer> map = new LinkedHashMap();

        for (int i = 0; i < arr.length; i++) {
            map.putIfAbsent(arr[i], 0);
            map.put(arr[i], map.get(arr[i]) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            if (entry.getValue() > 1) return entry.getKey();

        }

        return -1;
    }

    static void findFirstRepeatingElement(int[] arr) {
        Set<Integer> set = new HashSet<>();

        int min = -1;

        for (int i = arr.length - 1; i >= 0; i--) {

            if (set.contains(arr[i])) {
                min = i;
            } else {
                set.add(arr[i]);
            }

        }

        if (min != -1) {
            System.out.println(arr[min]);
        } else {
            System.out.println("-1");
        }
    }

}
