package tree;

public class LeastCommonAncestor
{
  public static void main(String[] args)
  {
    Node root = new Node(9);
    root.left = new Node(4);
    root.right = new Node(17);
//    root.left.left = new Node(3);
//    root.left.right = new Node(6);
//    root.left.right.left = new Node(5);
//    root.left.right.right = new Node(7);
//    root.right.right = new Node(22);
//    root.right.right.left = new Node(20);

    int n1 = 9;
    int n2 = 4;
    System.out.println("LCA::" + getLCA(root, n1, n2).data);
  }

  private static Node getLCA(Node root, int n1, int n2)
  {
    if (root == null || root.data == n1 || root.data == n2) { return root; }

    Node left = getLCA(root.left, n1, n2);
    Node right = getLCA(root.right, n1, n2);

    if (left == null) { return right; }
    else if (right == null) { return left; }
    else
    { return root; }
  }
}
