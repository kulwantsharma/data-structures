package main.java.tries;

public class Trie {

    private TrieNode root = new TrieNode();

    public void insert(String str) {

        TrieNode ptr = root;
        for (int i = 0; i < str.length(); i++) {

            int k = str.charAt(i) - 'a';
            TrieNode node = ptr.nodes[k];
            if (node == null) {
                node = new TrieNode();
                ptr.nodes[k] = node;
            }
            ptr = node;
        }
        ptr.isEndOfWord = true;
    }

    public void delete(String str) {

        TrieNode ptr = root;
        for (int i = 0; i < str.length(); i++) {

            int k = str.charAt(i) - 'a';
            TrieNode node = ptr.nodes[k];
            if (node == null) {
                System.out.println("Word doesn't exist in the Trie Data Structure");
                return;
            }
            ptr = node;
        }
        ptr.isEndOfWord = false;
    }

    public boolean search(String str) {

        TrieNode ptr = root;
        for (int i = 0; i < str.length(); i++) {

            int k = str.charAt(i) - 'a';
            TrieNode node = ptr.nodes[k];
            if (node == null) {
                return false;
            }
            ptr = node;
        }

        return ptr.isEndOfWord;
    }

}
