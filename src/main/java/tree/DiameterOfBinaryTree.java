package tree;

//https://www.geeksforgeeks.org/diameter-of-a-binary-tree/
public class DiameterOfBinaryTree {
    static int diameter = 1;

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        System.out.println(diameter(root));
    }

    /* Complete the function to get diameter of a binary tree */
    public static int diameter(Node root) {

        diameter = 1;
        getDiameter(root);
        return diameter;

    }

    private static int getDiameter(Node root) {

        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) return 1;
        int left = getDiameter(root.left);
        int right = getDiameter(root.right);
        diameter = Math.max(diameter, left + right + 1);
        return 1 + Math.max(left, right);
    }
}

