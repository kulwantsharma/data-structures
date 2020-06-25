package main.java.string;

import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/word-break-problem-trie-solution/
public final class WordBreakTrieSolution {
    public static void main(String[] args) {

//        String dictionary[] = {"mobile", "samsung", "sam", "sung",
//                "man", "mango", "icecream", "and", "go", "i", "like", "ice", "cream"};

        String dictionary[] = {"cat", "cats", "and", "sand", "dog"};

        Dictionary wordDictionary = new Dictionary();
        for (int i = 0; i < dictionary.length; i++) {
            wordDictionary.insert(dictionary[i]);
        }

//        for (int i = 0; i < dictionary.length; i++) {
//            System.out.println(wordDictionary.search(dictionary[i]));
//        }

//        String sentence = "ilikesamsungmobil";
//        String sentence = "ilikesamsungmobile";
//        String sentence = "ilikesamsungmobileandmango";
//        String sentence = "ilikesamsungmobileandmangok";
        String sentence = "mangoilikeandilikesamsungmobilesamsungsungsamandsungsungsamsami";


//        System.out.println("Sentence can be broken:" + wordDictionary.wordBreak(sentence));

        //Alternate Solution with Queue
//        System.out.println("Sentence can be broken using Queue:" + wordDictionary.searchSentence(sentence));


        sentence = "catsanddog";
        wordDictionary.printAllBrokenSentence(sentence);

    }

    static class Dictionary {

        TrieNode root = new TrieNode();

        public boolean wordBreak(String sentence) {

            if (sentence.isEmpty()) return true;

            for (int i = 1; i <= sentence.length(); i++) {

                if (search(sentence.substring(0, i)) && wordBreak(sentence.substring(i))) {
                    return true;
                }

            }
            return false;
        }

        public void insert(String word) {
            TrieNode ptr = root;

            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (ptr.children[index] == null) {
                    ptr.children[index] = new TrieNode();
                }
                ptr = ptr.children[index];
            }
            ptr.isEndOfWord = true;
        }

        public boolean search(String word) {

            TrieNode ptr = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (ptr.children[index] == null) {
                    return false;
                }
                ptr = ptr.children[index];
            }
            return ptr.isEndOfWord;
        }

        public boolean searchSentence(String sentence) {

            TrieNode ptr = root;
            Queue<Integer> queue = new LinkedList<>();
            int i = 0;

//            stack.push(i);
            queue.offer(i);


            while (true) {

                if (i == sentence.length() && ptr.isEndOfWord) return true;
//                if (stack.isEmpty()) return false;
                if (queue.isEmpty()) return false;
                ptr = root;
                for (i = queue.poll(); i < sentence.length(); i++) {
                    int index = sentence.charAt(i) - 'a';
                    if (ptr.children[index] != null) {
                        ptr = ptr.children[index];
                        if (ptr.isEndOfWord) {
                            if (i == sentence.length()) {
                                return true;
                            } else {
                                queue.offer(i + 1);
                            }
                        }
                    } else {
                        break;
                    }
                }


            }
//            return false;
        }

        // Incomplete : Not Working
        public void printAllBrokenSentence(String sentence) {

            TrieNode ptr = root;
            Queue<Integer> queue = new LinkedList<>();
            int i = 0;

//            stack.push(i);
            queue.offer(i);

            StringBuilder spaceSeparatedSentence = new StringBuilder();
            while (!queue.isEmpty()) {

                if (i == sentence.length() && ptr.isEndOfWord) {
                    System.out.println(spaceSeparatedSentence.toString());
                    spaceSeparatedSentence = new StringBuilder();
                }

                ptr = root;
                for (i = queue.poll(); i < sentence.length(); i++) {
                    int index = sentence.charAt(i) - 'a';
                    if (ptr.children[index] != null) {
                        spaceSeparatedSentence.append(sentence.charAt(i));
                        ptr = ptr.children[index];
                        if (ptr.isEndOfWord) {
                            spaceSeparatedSentence.append(' ');
                            if (i == sentence.length()) {
                                System.out.println(spaceSeparatedSentence.toString());
                                spaceSeparatedSentence = new StringBuilder();
                            } else {
                                queue.offer(i + 1);
                            }
                        }
                    } else {
                        break;
                    }
                }


            }
//            return false;
        }
    }

    static class TrieNode {
        TrieNode[] children;
        boolean isEndOfWord;

        TrieNode() {
            children = new TrieNode[26];
            isEndOfWord = false;
        }
    }

}
