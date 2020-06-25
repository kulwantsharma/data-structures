package main.java.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//https://www.geeksforgeeks.org/word-break-problem-dp-32/
public final class WordBreak1 {
    public static void main(String[] args) {

        String temp_dictionary[] = {"mobile", "samsung", "sam", "sung",
                "man", "mango", "icecream", "and",
                "go", "i", "like", "ice", "cream"};


        Set<String> dictionary = new HashSet<>();
        dictionary.addAll(Arrays.asList(temp_dictionary));

//        String word = "ilikesam";
        String word = "ilikesamsungandicecream";

        boolean isWordBroken = wordBreakRecursive(dictionary, word);
        System.out.println(isWordBroken);


        isWordBroken = wordBreakDynamic(dictionary, word);
        System.out.println(isWordBroken);


//        temp_dictionary = new String[]{"cat", "cats", "and", "sand", "dog"};
//        word = "catsanddog";
        word = "ilikeicecreamandmango";


//        temp_dictionary = new String[]{"apple", "pen", "applepen", "pine", "pineapple"};
//        word = "pineapplepenapple";

        dictionary = new HashSet<>();
        dictionary.addAll(Arrays.asList(temp_dictionary));

        printAllSentences(dictionary, word, "");

    }

    private static void printAllSentences(Set<String> dictionary, String word, String sentence) {

        if (word.isEmpty()) {
            System.out.println(sentence);
            return;
        }

        for (int i = 1; i <= word.length(); i++) {

            if (dictionary.contains(word.substring(0, i))) {
                printAllSentences(dictionary, word.substring(i), sentence + word.substring(0, i) + ' ');
            }

        }

    }

    private static boolean wordBreakDynamic(Set<String> dictionary, String word) {

        if (word.isEmpty()) return true;

        boolean[] wb = new boolean[word.length() + 1];

        for (int i = 1; i <= word.length(); i++) {

            if (!wb[i] && dictionary.contains(word.substring(0, i))) {
                wb[i] = true;
            }

            if (wb[word.length()]) return true;

            if (wb[i]) {

                for (int j = i + 1; j <= word.length(); j++) {

                    if (!wb[j] && dictionary.contains(word.substring(i, j))) {
                        wb[j] = true;
                    }

                }

                if (wb[word.length()]) return true;

            }
        }
        return false;
    }


    private static boolean wordBreakRecursive(Set<String> dictionary, String word) {

        if (word.isEmpty()) return true;

        for (int i = 1; i <= word.length(); i++) {

            if (dictionary.contains(word.substring(0, i)) && wordBreakRecursive(dictionary, word.substring(i))) {
                return true;
            }

        }
        return false;
    }

}
