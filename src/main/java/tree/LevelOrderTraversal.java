package main.java.tree;

import java.util.LinkedList;
import java.util.Queue;

public final class LevelOrderTraversal {
    public static void main(String[] args) {

        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);

        root.left.left = new Node(4);
        root.left.right = new Node(12);

        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);

        printLevelOrder(root);
        System.out.println();
        printLevelOrderUsingHeight(root);

    }

    private static void printLevelOrder(Node root) {

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);

        while (!queue.isEmpty()) {

            Node node = queue.poll();


            if (node == null) {
                if (queue.isEmpty()) {
                    break;
                } else {
                    queue.offer(null);
                    System.out.println();
                }
            } else {
                System.out.print(node.data + " ");
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
    }

    private static void printLevelOrderUsingHeight(Node root) {

        int height = getHeight(root);
        for (int i = 0; i < height; i++) {
            printNodeAtHeightI(root, i);
            System.out.println();
        }

    }

    private static int getHeight(Node root) {
        return root == null ? 0 : 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    private static void printNodeAtHeightI(Node root, int i) {

        if (root == null) {
            return;
        }

        if (i == 0) {
            System.out.print(root.data+" ");
        }

        printNodeAtHeightI(root.left, i - 1);
        printNodeAtHeightI(root.right, i - 1);

    }
}

