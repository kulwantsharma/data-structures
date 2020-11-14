package tree;

//https://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
public class BSTCheck {
    public static void main(String[] args) {

        Node root = new Node(9);
        root.left = new Node(4);
        root.right = new Node(17);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.left.right.left = new Node(5);
        root.left.right.right = new Node(7);
        root.right.right = new Node(22);
        root.right.right.left = new Node(20);

        //Adding to make it not BSTCheck
//        root.right.right.left.left = new Node(21);

        System.out.println(isBST(root));

    }

    public static boolean isBST(Node root) {

        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

    }

    private static boolean isBSTUtil(Node root, int minValue, int maxValue) {

        if (root == null) return true;

        if (root.data < minValue || root.data > maxValue) return false;

        return isBSTUtil(root.left, minValue, root.data) &&
                isBSTUtil(root.right, root.data, maxValue);

    }
}
