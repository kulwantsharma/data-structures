package tree;

public class ConvertBSTToGreaterSumTree {
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

        printTree(root);

        convertToGreaterTree(root,new  Sum());

        System.out.println();
        printTree(root);
    }


    private static void convertToGreaterTree(Node root, Sum sum_ptr) {

        if(root == null) return;

        convertToGreaterTree(root.right,sum_ptr);

        int temp = root.data;
        root.data = sum_ptr.sum;
        sum_ptr.sum = sum_ptr.sum + temp;

        convertToGreaterTree(root.left,sum_ptr);


    }


    private static void printTree(Node root) {

        if(root == null) return;

        printTree(root.left);
        System.out.print(root.data + " ");
        printTree(root.right);

    }

    static class Sum{
        int sum;
    }
}
