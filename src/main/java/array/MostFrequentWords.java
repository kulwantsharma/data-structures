package array;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//https://www.geeksforgeeks.org/frequent-word-array-strings/
public class MostFrequentWords {
    public static void main(String[] args) {

        String arr[] = {"geeks", "for", "geeks", "a",
                "portal", "to", "learn", "can",
                "be", "computer", "science",
                "zoom", "yup", "fire", "in",
                "be", "data", "geeks"};

        System.out.println("Most Frequent Word:" + getMostFrequentWord(arr));

    }

    private static String getMostFrequentWord(String[] arr) {

        Map<String, Integer> map = new HashMap<>();
        for (String str : arr) {
            if (map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
            } else {
                map.put(str, 1);
            }
        }

        String word = "";
        int count = Integer.MIN_VALUE;

        for(Map.Entry<String,Integer> entry : map.entrySet()){

            if(entry.getValue() > count){
                count = entry.getValue();
                word = entry.getKey();
            }

        }

        return word;
    }
}
