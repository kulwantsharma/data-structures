package test.furloughPractice.ternary;

public class TernarySearchTree {

    Node root = null;

    public void insert(String word) {

        root = insert(root, word, 0);

    }

    private Node insert(Node root, String word, int i) {

        if (root == null) {
            root = new Node(word.charAt(i));
        }

        if (root.data < word.charAt(i)) {
            root.right = insert(root.right, word, i);
        } else if (root.data > word.charAt(i)) {
            root.left = insert(root.left, word, i);
        } else {
            if (word.length() > i + 1) {
                root.equal = insert(root.equal, word, i + 1);
            } else {
                root.isEndOfWord = true;
            }
        }
        return root;

    }

    public boolean search(String str) {

        return search(root, str, 0);

    }

    private boolean search(Node root, String word, int i) {

        if(root == null || i == word.length()) return false;

        if(i+1 == word.length() && root.data == word.charAt(i) && root.isEndOfWord) return true;

        if(root.data < word.charAt(i))
            return search(root.right,word,i);
        else if(root.data > word.charAt(i)){
            return search(root.left, word, i);
        }else{
            return search(root.equal,word,i+1);
        }

    }

//    public boolean search(String str) {
//    }
}
