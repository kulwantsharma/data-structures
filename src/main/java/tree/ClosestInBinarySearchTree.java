package tree;

public class ClosestInBinarySearchTree {
    static int closest = -1;
    static int previous = -1;

    //For BST
    static int mid_diff = Integer.MAX_VALUE;
    static int closest_key = -1;

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


//        for (int k = 1; k <= 23; k++) {
//            closest = -1;
//            previous = -1;
//            findClosest(root, k);
//            if (closest == -1) {
//                closest = previous;
//            }
//            System.out.println("k:" + k + "  closest:" + closest);
//        }


        //
        for (int k = 1; k <= 23; k++) {
            closest_key = -1;
            mid_diff = Integer.MAX_VALUE;
            findClosestUsingBST(root, k);
            System.out.println("k:" + k + "  closest:" + closest_key);
        }


    }

    private static void findClosest(Node root, int k) {
        if (root == null) return;

        findClosest(root.left, k);

        if (root.data == k) {
            closest = root.data;
            previous = closest;
            return;
        } else if (root.data < k) {
            previous = root.data;
        } else {

            if (previous == -1) {
                closest = root.data;
                previous = root.data;
            } else if (closest == -1) {
                int diff1 = Math.abs(previous - k);
                int diff2 = Math.abs(root.data - k);

                closest = diff2 <= diff1 ? root.data : previous;
            }

        }
        findClosest(root.right, k);
    }

    private static void findClosestUsingBST(Node root, int k) {

        if (root == null) return;

        if (mid_diff > Math.abs(k - root.data)) {
            mid_diff = Math.abs(k - root.data);
            closest_key = root.data;
        }

        if (k > root.data) {

            findClosestUsingBST(root.right, k);

        } else {
            findClosestUsingBST(root.left, k);
        }

    }

}
