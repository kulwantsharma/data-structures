package string;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


//https://www.geeksforgeeks.org/find-the-k-most-frequent-words-from-a-file/
public class MaxOccuringWordFromFileTrieDS {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("C:\\Users\\H359968\\Documents\\MyPersonal\\GitTest\\learning-project\\src\\main\\java\\sorting\\Word.txt");

        int k = 4;
        String[] words = printMaxOccurringWords(file, k);

        System.out.println("Max Occurring Word");
        for (int i = 0; i < k; i++) {
            System.out.print(words[i] + " ");
        }

    }

    private static String[] printMaxOccurringWords(File file, int k) throws FileNotFoundException {

        Scanner sc = new Scanner(file);
        MinHeap minHeap = new MinHeap(k);
        Trie trie = new Trie();

        for (int i = 0; i < k && sc.hasNext(); i++) {

            String word = sc.next();
            int count = trie.insert(word);

            if (checkIfPresentInHeap(minHeap, word)) {
                increaseCount(minHeap, word);
                minHeap.buildHeap();
            } else {
                minHeap.add(word, count);
                minHeap.buildHeap();
            }

        }


        while (sc.hasNext()) {
            String word = sc.next();
            int count = trie.insert(word);

            if (checkIfPresentInHeap(minHeap, word)) {
                increaseCount(minHeap, word);
                minHeap.buildHeap();
            } else {
                if (count > minHeap.arr[0].count) {
                    minHeap.arr[0] = new MinHeap.MinHeapNode(word, count);
                    minHeap.buildHeap();
                }
            }

        }

        return extractKMaxOccuringWordUtil(minHeap, k);

    }

    private static String[] extractKMaxOccuringWordUtil(MinHeap minHeap, int k) {

        String[] words = new String[k];
        for (int i = 0; i < minHeap.size; i++) {
            words[i] = minHeap.arr[i].word;
        }
        return words;
    }

    private static boolean checkIfPresentInHeap(MinHeap minHeap, String word) {

        for (int i = 0; i < minHeap.size; i++) {
            if (minHeap.arr[i].word.equals(word)) {
                return true;
            }
        }
        return false;
    }

    private static void increaseCount(MinHeap minHeap, String word) {
        for (int i = 0; i < minHeap.size; i++) {
            if (minHeap.arr[i].word.equals(word)) {
                minHeap.arr[i].count++;
            }
        }
    }

    static class MinHeap {

        MinHeapNode[] arr = null;
        int maxSize;
        int size = 0;

        MinHeap(int size) {
            this.maxSize = size;
            arr = new MinHeapNode[size];
        }

        public void add(String word, int count) {

            if (size < maxSize) {
                arr[size++] = new MinHeapNode(word, count);
            }

        }

        private void buildHeap() {
            int lastNonLeafIndex = size / 2 - 1;
            for (int i = lastNonLeafIndex; i >= 0; i--) {
                heapify(i);
            }
        }

        private void heapify(int index) {

            int leftChildIndex = index * 2 + 1;
            int rightChildIndex = index * 2 + 2;

            int minIndex = index;

            if (leftChildIndex < size && arr[leftChildIndex].count < arr[minIndex].count) {
                minIndex = leftChildIndex;
            }
            if (rightChildIndex < size && arr[rightChildIndex].count < arr[minIndex].count) {
                minIndex = rightChildIndex;
            }

            if (minIndex != index) {
                MinHeapNode temp = arr[minIndex];
                arr[minIndex] = arr[index];
                arr[index] = temp;
                heapify(minIndex);
            }
        }

        static class MinHeapNode {

            String word;
            int count;

            MinHeapNode(String word, int count) {
                this.word = word;
                this.count = count;
            }

        }
    }

    static class Trie {

        TrieNode root = null;

        Trie() {
            root = new TrieNode();
        }

        public int insert(String word) {

            TrieNode ptr = root;

            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i);
                if (ptr.children[index] == null) {
                    TrieNode temp = new TrieNode();
                    ptr.children[index] = temp;
                    ptr = temp;
                } else {
                    ptr = ptr.children[index];
                }
            }
            ptr.isEndOfWord = true;
            ptr.count++;

            return ptr.count;
        }

        public boolean search(String word) {

            TrieNode ptr = root;
            for (int i = 0; i < word.length(); i++) {

                int index = word.charAt(i);
                if (ptr.children[index] == null) {
                    return false;
                } else {
                    ptr = ptr.children[index];
                }

            }
            return ptr.isEndOfWord;
        }

        class TrieNode {

            TrieNode[] children = null;
            boolean isEndOfWord;
            int count;

            TrieNode() {
                children = new TrieNode[256];
            }
        }
    }

}
