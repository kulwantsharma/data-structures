package main.java.string;

import java.util.HashSet;
import java.util.Set;

//https://www.geeksforgeeks.org/amazon-interview-set-27/
public final class PrintAllSubsetsOfString {
    public static void main(String[] args) {

        String str = "aaabaa";
        Set<String> dictionary = new HashSet<>();
        dictionary.add("a");
        dictionary.add("aa");
        dictionary.add("aaa");

        printAllSubsets(str, dictionary);

    }

    private static void printAllSubsets(String str, Set<String> dictionary) {

        for (int i = 1; i <= str.length(); i++) {
            for (int j = 0; j < str.length() - i; j++) {
                StringBuilder sb = new StringBuilder();
                for (int k = j; k < j + i && k < str.length(); k++) {
                    sb.append(str.charAt(k));
                }
                if (dictionary.contains(sb.toString())) {
                    System.out.print(sb.toString() + ", ");
                }
            }
        }

    }
}
