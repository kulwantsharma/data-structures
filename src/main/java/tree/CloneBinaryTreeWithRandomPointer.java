package tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

//https://www.geeksforgeeks.org/clone-binary-tree-random-pointers/
public class CloneBinaryTreeWithRandomPointer {
    public static void main(String[] args) {

        Node root = new Node(6);
        root.left = new Node(3);
        root.right = new Node(8);

        root.left.left = new Node(1);
        root.left.right = new Node(5);

        //Setting Ranaom Pointer in Origin Tree
        root.left.right.random = root;
        root.left.left.random = root.left;

//        printInOrder(root);

        Node clonedTree = cloneTree(root);
        printInOrder(clonedTree);

    }

    public static Node cloneTree(Node root) {

        if (root == null) return null;

        HashMap<Node, Node> map = new HashMap<>();
        Node clonedTree = cloneTreeUtil(root, map);

        setRandomPointer(root, clonedTree, map);

        return clonedTree;

    }

    private static void setRandomPointer(Node root, Node clonedTree, HashMap<Node, Node> map) {

        if (root == null) return;

        if (root.random != null) {
            clonedTree.random = map.get(root.random);
        }

        setRandomPointer(root.left, clonedTree.left, map);
        setRandomPointer(root.right, clonedTree.right, map);

    }

    private static Node cloneTreeUtil(Node root, Map<Node, Node> map) {

        Queue<Node> queue = new LinkedList<>();
        Node clonedTree = new Node(root.data);

        queue.offer(root);
        queue.offer(clonedTree);
        map.put(root, clonedTree);

        while (!queue.isEmpty()) {

            Node existingTreeNode = queue.poll();
            Node clonedTreeNode = queue.poll();

            if (existingTreeNode.left != null) {
                clonedTreeNode.left = new Node(existingTreeNode.left.data);
                map.put(existingTreeNode.left, clonedTreeNode.left);
                queue.offer(existingTreeNode.left);
                queue.offer(clonedTreeNode.left);
            }
            if (existingTreeNode.right != null) {

                clonedTreeNode.right = new Node(existingTreeNode.right.data);
                map.put(existingTreeNode.right, clonedTreeNode.right);
                queue.offer(existingTreeNode.right);
                queue.offer(clonedTreeNode.right);

            }

        }

        return clonedTree;

    }

    private static void printInOrder(Node root) {

        if (root == null) return;

        printInOrder(root.left);
        System.out.print(root.data + " ");
        printInOrder(root.right);

    }
}
