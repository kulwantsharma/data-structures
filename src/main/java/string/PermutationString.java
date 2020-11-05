package string;

import java.util.HashMap;
import java.util.Map;

public final class PermutationString {
    public static void main(String[] args) {

        System.out.println(IsPermutationPresent("abc".toCharArray(), "huklbcajif".toCharArray()));
        System.out.println(IsPermutationPresent("abc".toCharArray(), "cab".toCharArray()));
        System.out.println(IsPermutationPresent("abc".toCharArray(), "xyz".toCharArray()));
        System.out.println(IsPermutationPresent("abc".toCharArray(), "xyzabc".toCharArray()));
        System.out.println(IsPermutationPresent("abc".toCharArray(), "bxyzac".toCharArray()));
        System.out.println(IsPermutationPresent("abc".toCharArray(), "a".toCharArray()));

    }

    private static boolean IsPermutationPresent(char[] s1, char[] s2) {

        Map<Character, Integer> charMap = new HashMap<>();

        for (int i = 0; i < s1.length; i++) {
            charMap.putIfAbsent(s1[i], 0);
            charMap.put(s1[i], charMap.get(s1[i]) + 1);
        }

        Map<Character, Integer> copy = new HashMap<>(charMap);
        int count;

        for (int i = 0; i < s2.length; i++) {
            count = s1.length;
            for (int j = i; j < i + s1.length && j < s2.length; j++) {
                if (copy.containsKey(s2[j]) && copy.get(s2[j]) > 0) {
                    count--;
                    copy.put(s2[j], copy.get(s2[j]) - 1);
                }
            }

            if (count == 0) {
                return true;
            } else {
                copy = new HashMap<>(charMap);
            }

        }

        return false;

    }
}
