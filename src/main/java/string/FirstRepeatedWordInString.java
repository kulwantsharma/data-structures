package main.java.string;

import java.util.HashSet;

//https://www.geeksforgeeks.org/find-first-repeated-word-string/?ref=rp
public class FirstRepeatedWordInString {
    public static void main(String[] args) {

//        String str = "Ravi had been saying that he had been there";
//        String str = "Ravi had been saying that";
        String str = "he had had he";

        printFirstRepeated(str.split(" "));

    }

    private static void printFirstRepeated(String[] str) {

        HashSet<String> hashSet = new HashSet<>();

        String repeatedWord = null;

        for (int i = str.length - 1; i >= 0; i--) {

            if (hashSet.contains(str[i])) {
                repeatedWord = str[i];
            } else {
                hashSet.add(str[i]);
            }
        }

        if (repeatedWord == null) {
            System.out.println("No Repeatation");
        } else {
            System.out.println(repeatedWord);
        }

    }
}
