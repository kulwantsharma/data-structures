package main.java;

import java.util.Arrays;
import java.util.HashSet;

public class Test {
    public static void main(String args[]) {

        String temp_dictionary[] = {"mobile", "samsung", "sam", "sung", "man", "mango",
                "icecream", "and", "go", "i", "like", "ice", "cream"};

        HashSet<String> dictionary = new HashSet<>(Arrays.asList(temp_dictionary));
        if (wordBreak(dictionary, "ilikesamsung")) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        if (wordBreak(dictionary, "iiiiiiii")) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        if (wordBreak(dictionary, "")) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        if (wordBreak(dictionary, "ilikelikeimangoiii")) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        if (wordBreak(dictionary, "samsungandmango")) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        if (wordBreak(dictionary, "samsungandmangok")) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static boolean wordBreak(HashSet<String> dictionary, String str) {
        int size = str.length();
        if (size == 0) return true;

        // Create the DP table to store results of subroblems. The value wb[i]
        // will be true if str[0..i-1] can be segmented into dictionary words,
        // otherwise false.
        boolean wb[] = new boolean[size + 1];
//        memset(wb, 0, sizeof(wb)); // Initialize all values as false.

        for (int i = 1; i <= size; i++) {
            // if wb[i] is false, then check if current prefix can make it true.
            // Current prefix is "str.substr(0, i)"
            if (wb[i] == false && dictionary.contains(str.substring(0, i)))
                wb[i] = true;

            // wb[i] is true, then check for all substrings starting from
            // (i+1)th character and store their results.
            if (wb[i] == true) {
                // If we reached the last prefix
                if (i == size)
                    return true;

                for (int j = i + 1; j <= size; j++) {
                    // Update wb[j] if it is false and can be updated
                    // Note the parameter passed to dictionaryContains() is
                    // substring starting from index 'i' and length 'j-i'
                    if (wb[j] == false && dictionary.contains(str.substring(i, j)))
                        wb[j] = true;

                    // If we reached the last character
                    if (j == size && wb[j] == true)
                        return true;
                }
            }
        }

    /* Uncomment these lines to print DP table "wb[]"
     for (int i = 1; i <= size; i++)
        cout << " " << wb[i]; */

        // If we have tried all prefixes and none of them worked
        return false;
    }

    // Driver program to test above functions

}
