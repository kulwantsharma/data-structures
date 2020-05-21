package main.java.tries;

public class TrieDataStructureTest {
    public static void main(String[] args) {

        Trie trie = new Trie();

        String str = "kulwant";
        trie.insert(str);

//        trie.delete(str);

        str = "kulwant";
        System.out.println(trie.search(str));

    }

}
