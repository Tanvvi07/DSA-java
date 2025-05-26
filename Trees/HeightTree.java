package Trees;
import java.util.*;

// Node class representing each node in the binary tree
class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class HeightTree {
    // Function to find the height of a binary tree.
    int height(Node node) {
        if (node == null)
            return -1; // use 0 if height of empty tree is considered 0
        int left = height(node.left);
        int right = height(node.right);
        return Math.max(left, right) + 1;
    }

    // Helper method to build tree from level order input
    Node buildTree(Scanner sc) {
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

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HeightTree h = new HeightTree();
        Node root = h.buildTree(sc);
        int treeHeight = h.height(root);
        System.out.println("Height of the binary tree: " + treeHeight);
        sc.close();
    }
}

