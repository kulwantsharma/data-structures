package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

//https://practice.geeksforgeeks.org/problems/serialize-and-deserialize-a-binary-tree/1
public class SerializeDeserializeBinaryTree {
    public static void main(String[] args) {

        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.right.right = new Node(25);
        root.left.left = new Node(5);
        root.left.right = new Node(13);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        printInorder(root);
        System.out.println();
        printPreOrder(root);

        List<Integer> list = new LinkedList<>();
        serialize(root, list);
        System.out.println(list);
//        root = deserialize(list);
//
//        printInorder(root);
//        System.out.println();
//        printPreOrder(root);


    }

    private static Node deserialize(List<Integer> list) {
        return null;
    }

    private static void deserializeUtil(List<Integer> list) {


        Stack<Node> stack = new Stack<>();


    }

    private static void serialize(Node root, List<Integer> list) {

        if (root == null) {
            list.add(-1);
            return;
        }

        list.add(root.data);
        serialize(root.left, list);
        serialize(root.right, list);

    }

    private static void printInorder(Node root) {

        if (root == null) {
            return;
        }

        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    private static void printPreOrder(Node root) {

        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        printPreOrder(root.left);
        printPreOrder(root.right);
    }
}
