package tree;

import java.util.ArrayList;
import java.util.List;

//https://www.geeksforgeeks.org/fix-two-swapped-nodes-of-bst/
public class CorrectTheBST {

    static int node1 = Integer.MIN_VALUE;
    static int node2 = Integer.MIN_VALUE;

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
        root.right.right.left.right = new Node(21);

        //Scenario one
//        root.data = 3;
//        root.left.left.data = 9;
//        System.out.println("IsBST:" + BSTCheck.isBST(root));
//        correctBST(root);
//        printTree(root);
//        System.out.println("IsBST:" + BSTCheck.isBST(root));


        //Scenario two
//        root.right.right.data = 6;
//        root.left.right.data = 22;
//        System.out.println("IsBST:" + BSTCheck.isBST(root));
//        correctBST(root);
//        printTree(root);
//        System.out.println("IsBST:" + BSTCheck.isBST(root));


        //Scenario three
//        root.right.data = 6;
//        root.left.right.data = 17;
//        System.out.println("IsBST:" + BSTCheck.isBST(root));
//        correctBST(root);
//        printTree(root);
//        System.out.println("IsBST:" + BSTCheck.isBST(root));


        //Scenario four
//        root.left.left.data = 22;
//        root.right.right.data = 3;
//        System.out.println("IsBST:" + BSTCheck.isBST(root));
//        correctBST(root);
//        printTree(root);
//        System.out.println("IsBST:" + BSTCheck.isBST(root));


        //test
        root = null;
        root = new Node(93);
        root.left = new Node(61);
        root.right = new Node(87);
        root.left.left = new Node(9);

        System.out.println("IsBST:" + BSTCheck.isBST(root));
        System.out.println("Before Correction");
        printTree(root);
        System.out.println();
        correctBST(root);
        System.out.println("After Correction");
        printTree(root);
        System.out.println("IsBST:" + BSTCheck.isBST(root));

    }

    private static void printTree(Node root) {

        if (root == null) return;
        printTree(root.left);
        System.out.print(root.data + " ");
        printTree(root.right);

    }

    private static void correctBST(Node root) {

        List<Integer> list = new ArrayList<>();
        findInOrder(root, list);
        node1 = Integer.MIN_VALUE;
        node2 = Integer.MIN_VALUE;
        findNodes(list);

//        System.out.println("Node1:" + node1 + " Node2:" + node2);

        correctBSTUtil(root, node1, node2);
//        System.out.println(list);

    }

    private static void correctBSTUtil(Node root, int node1, int node2) {

        if (root == null) return;

        correctBSTUtil(root.left, node1, node2);

        if (root.data == node1) {
            root.data = node2;
        } else if (root.data == node2) {
            root.data = node1;
        }

        correctBSTUtil(root.right, node1, node2);

    }

    private static void findNodes(List<Integer> list) {

        int k = Integer.MIN_VALUE;
        for (int i = 1; i < list.size(); i++) {

            if (list.get(i - 1) > list.get(i) && node1 == Integer.MIN_VALUE) {
                node1 = list.get(i - 1);
                k = i - 1;
            } else if (list.get(i - 1) > list.get(i) && node2 == Integer.MIN_VALUE) {
                node2 = list.get(i);
            }

            if (node1 != Integer.MIN_VALUE && node2 != Integer.MIN_VALUE) {
                break;
            }
        }

        if (node2 == Integer.MIN_VALUE) {
            node2 = list.get(k + 1);
        }

    }

    private static void findInOrder(Node root, List<Integer> list) {
        if (root == null) return;
        findInOrder(root.left, list);
        list.add(root.data);
        findInOrder(root.right, list);
    }
}
