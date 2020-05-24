package main.java.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public final class StringFollowsPattern {
    public static void main(String[] args) {

        String str = "engineers rock";
        String pattern = "er";
//        String pattern = "egr";
//        String pattern = "gsr";

//        System.out.println("Follows Pattern:" + doesStringFollowsPattern(str, pattern));
        System.out.println("Follows Pattern:" + doesStringFollowsPatternUsingHashSet(str, pattern));
    }


    private static boolean doesStringFollowsPattern(String str, String pattern) {

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < pattern.length(); i++) {
            map.put(pattern.charAt(i), 0);
        }

        for (int i = 0, j = 0; i < pattern.length(); i++) {

            char ch = pattern.charAt(i);

            for (; j < str.length(); j++) {

                if (map.containsKey(str.charAt(j))) {
                    if (ch != str.charAt(j)) {
                        if (map.get(str.charAt(j)) == 1) {
                            return false;
                        } else {
                            map.put(ch, 1);
                            break;
                        }
                    } else {
                        if (map.get(str.charAt(j)) == 1) {
                            return false;
                        }
                    }
                }

            }

        }

        return true;
    }

    private static boolean doesStringFollowsPatternUsingHashSet(String str, String pattern) {

        HashSet<Character> hashSet = new HashSet<>();
        for (int i = 0; i < pattern.length(); i++) {
            hashSet.add(pattern.charAt(i));
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {

            if (hashSet.contains(str.charAt(i))) {
                if (result.length() == 0 || result.charAt(result.length() - 1) != str.charAt(i)) {
                    result.append(str.charAt(i));
                }
            }

        }

        System.out.println("result:" + result.toString());
        System.out.println("Pattern:" + pattern);

        return pattern.equals(result.toString());
    }


}
