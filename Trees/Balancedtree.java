package Trees;

import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
    }
}

public class Balancedtree {

    // Method to check if tree is balanced
    public boolean isBalanced(Node root) {
        if (root == null)
            return true;

        boolean left = isBalanced(root.left);
        boolean right = isBalanced(root.right);
        boolean diff = Math.abs(height(root.left) - height(root.right)) <= 1;

        return left && right && diff;
    }

    // Method to calculate height
    public int height(Node root) {
        if (root == null)
            return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    // Method to build tree from level order input
    public Node buildTree() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter root value (-1 for null):");
        int val = sc.nextInt();
        if (val == -1) return null;

        Node root = new Node(val);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            System.out.println("Enter left child of " + current.data + " (-1 for null):");
            int leftVal = sc.nextInt();
            if (leftVal != -1) {
                current.left = new Node(leftVal);
                queue.add(current.left);
            }

            System.out.println("Enter right child of " + current.data + " (-1 for null):");
            int rightVal = sc.nextInt();
            if (rightVal != -1) {
                current.right = new Node(rightVal);
                queue.add(current.right);
            }
        }

        return root;
    }

    public static void main(String[] args) {
        Balancedtree tree = new Balancedtree();
        Node root = tree.buildTree();
        System.out.println("Is tree balanced? " + tree.isBalanced(root));
    }
}

