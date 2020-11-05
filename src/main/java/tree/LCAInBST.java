package tree;

public class LCAInBST
{
  public static void main(String[] args)
  {
    Node root = new Node(9);
    root.left = new Node(4);
    root.right = new Node(17);
    root.left.left = new Node(3);
    root.left.right = new Node(6);
    root.left.right.left = new Node(5);
    root.left.right.right = new Node(7);
    root.right.right = new Node(22);
    root.right.right.left = new Node(20);

    int n1 = 9;
    int n2 = 22;

    int temp = 0;
    if (n1 > n2)
    {
      temp = n1;
      n1 = n2;
      n2 = temp;
    }
    System.out.println("n1:" + n1 + " n2:" + n2);
    System.out.println("LCA::" + findLCA(root, n1, n2).data);
  }

  private static Node findLCA(Node root, int n1, int n2)
  {
    if (root == null)
    {
      return root;
    }

    if (root.data > n1 && root.data > n2)
    {
      return findLCA(root.left, n1, n2);
    }
    if(root.data < n1 && root.data < n2)
    {
      return findLCA(root.right, n1, n2);
    }
    return root;
  }
}
