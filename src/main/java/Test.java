// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");

        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);

        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
            // Get and remove the front of the queue
            Node currNode = q.remove();

            // Get the current node's value from the string
            String currVal = s[i];

            // If the left child is not null
            if(!currVal.equals("N"))
            {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.left);
            }

            // For the right child
            i++;
            if(i >= s.length)
                break;
            currVal = s[i];

            // If the right child is not null
            if(!currVal.equals("N"))
            {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.right);
            }

            i++;
        }

        return root;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);

            int k = Integer.parseInt(br.readLine().trim());

            Solution T = new Solution();
            System.out.println(T.maxDiff(root,k));
            t--;
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    static int closest = -1;
    static int previous = -1;
    // Return the minimum absolute difference between any tree node and the integer K
    static int maxDiff(Node  root, int K)
    {
        closest = -1;
        previous = -1;


        findClosest(root,K);
        if (closest == -1) {
            closest = previous;
        }

        return closest;

    }

    private static void findClosest(Node root, int k) {
        if (root == null) return;

        findClosest(root.left, k);

        if (root.data == k) {
            closest = root.data;
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
}

