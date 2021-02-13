package tree;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

//https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1
public class BottomViewOfBinaryTree {
    public static void main(String[] args) {

        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
//        root.right.left = new Node(4);
//        root.right.left.right = new Node(14);
        root.right.right = new Node(25);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);


//        printInorder(root);
        ArrayList<Integer> integers = bottomView(root);
        System.out.println(integers);
    }


    // Method that returns the bottom view.
    public static ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> list = new ArrayList<>();
        Map<Integer, Node> map = new TreeMap<>();

        bottomViewUtil(root, map, 0, 0);

        for(Node node : map.values()){
            list.add(node.data);
        }

        return list;
    }

    public static void bottomViewUtil(Node root, Map<Integer, Node> map, int hd, int depth) {
        if (root == null) {
            return;
        }
        root.hd = depth;

        if(map.containsKey(hd)){
            Node node = map.get(hd);
            if(node.hd <= depth){
                map.put(hd,root);
            }
        }else{
            map.put(hd,root);
        }

        bottomViewUtil(root.left, map, hd - 1, depth + 1);  //left
        bottomViewUtil(root.right, map, hd + 1, depth + 1);  //right
    }


    public static void printInorder(Node root) {
        if (root == null) {
            return;
        }
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    static class Node {
        int data; //data of the node
        int hd; //horizontal distance of the node
        Node left, right; //left and right references

        // Constructor of tree node
        public Node(int key) {
            data = key;
            hd = Integer.MAX_VALUE;
            left = right = null;
        }
    }
}
