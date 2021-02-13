package string;

import java.util.Map;
import java.util.TreeMap;

//https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string/0
public class PermutationOfString {
    public static void main(String[] args) {

        String str = "AABC";
        permute(str.toCharArray());
    }

    private static void permute(char[] str) {

        Map<Character, Integer> map = new TreeMap<>();

        for (int i = 0; i < str.length; i++) {
            map.putIfAbsent(str[i], 0);
            map.put(str[i], map.get(str[i]) + 1);
        }


        char[] characters = new char[map.size()];
        int[] count = new int[map.size()];

        int index = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            characters[index] = entry.getKey();
            count[index] = entry.getValue();
            index++;
        }

        char[] result = new char[str.length];
        permuteUtil(characters, count, result, 0);
    }

    private static void permuteUtil(char[] characters, int[] count, char[] result, int depth) {

        if (depth == result.length) {
            for (char c : result) {
                System.out.print(c);
            }
            System.out.println();
            return;
        }
        for (int i = 0; i < count.length; i++) {

            if (count[i] > 0) {
                count[i]--;
                result[depth] = characters[i];
                permuteUtil(characters, count, result, depth + 1);
                count[i]++;
            }

        }

    }
}
