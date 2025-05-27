package Trees;
import java.util.*;

// Node class representing each node in the binary tree
class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class BoundaryTraversal {

    // Traverse the left boundary excluding leaf nodes
    void traverseLeft(Node node, ArrayList<Integer> ans) {
        if (node == null || (node.left == null && node.right == null))
            return;

        ans.add(node.data);
        if (node.left != null) {
            traverseLeft(node.left, ans);
        } else {
            traverseLeft(node.right, ans);
        }
    }

    // Traverse all leaf nodes
    void traverseLeaf(Node node, ArrayList<Integer> ans) {
        if (node == null)
            return;

        if (node.left == null && node.right == null) {
            ans.add(node.data);
            return;
        }

        traverseLeaf(node.left, ans);
        traverseLeaf(node.right, ans);
    }

    // Traverse the right boundary excluding leaf nodes (added bottom-up)
    void traverseRight(Node node, ArrayList<Integer> ans) {
        if (node == null || (node.left == null && node.right == null))
            return;

        if (node.right != null) {
            traverseRight(node.right, ans);
        } else {
            traverseRight(node.left, ans);
        }

        ans.add(node.data); // Add after recursive call for reverse order
    }

    // Main method for boundary traversal
    ArrayList<Integer> boundaryTraversal(Node node) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (node == null)
            return ans;

        if (!(node.left == null && node.right == null)) {
            ans.add(node.data); // Add root if not a leaf
        }

        traverseLeft(node.left, ans);
        traverseLeaf(node.left, ans);
        traverseLeaf(node.right, ans);
        traverseRight(node.right, ans);

        return ans;
    }

    // Entry point for testing
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node root = buildTree(sc);
        BoundaryTraversal bt = new BoundaryTraversal();
        ArrayList<Integer> result = bt.boundaryTraversal(root);
        System.out.println("Boundary Traversal: " + result);
        sc.close();
    }

    // Method to build tree using level order input
    static Node buildTree(Scanner sc) {
        System.out.println("Enter root value (-1 for null): ");
        int val = sc.nextInt();
        if (val == -1)
            return null;

        Node root = new Node(val);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            System.out.println("Enter left child of " + curr.data + " (-1 for null): ");
            int leftVal = sc.nextInt();
            if (leftVal != -1) {
                curr.left = new Node(leftVal);
                queue.add(curr.left);
            }

            System.out.println("Enter right child of " + curr.data + " (-1 for null): ");
            int rightVal = sc.nextInt();
            if (rightVal != -1) {
                curr.right = new Node(rightVal);
                queue.add(curr.right);
            }
        }
        return root;
    }
}
