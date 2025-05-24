package Trees;
import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    // Constructor
    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

class Solution {
    
    // Function to check if two trees are identical.
    boolean Identicaltree(Node r1, Node r2) {
        // Base cases
        if (r1 == null && r2 == null) {
            return true;
        }
        if (r1 == null || r2 == null) {
            return false;
        }

        // Check data and recursively check left and right subtrees
        return (r1.data == r2.data) &&
               Identicaltree(r1.left, r2.left) &&
               Identicaltree(r1.right, r2.right);
    }

    // Helper function to create a tree from user input
    Node buildTree(Scanner scanner) {
        System.out.print("Enter data for node (or -1 for null): ");
        int data = scanner.nextInt();
        if (data == -1) {
            return null;
        }
        Node node = new Node(data);
        System.out.println("Enter left child of " + data);
        node.left = buildTree(scanner);
        System.out.println("Enter right child of " + data);
        node.right = buildTree(scanner);
        return node;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solution solution = new Solution();
        
        // Build the first tree
        System.out.println("Enter the first tree:");
        Node root1 = solution.buildTree(scanner);
        
        // Build the second tree
        System.out.println("Enter the second tree:");
        Node root2 = solution.buildTree(scanner);
        
        // Check if trees are identical
        boolean result = solution.Identicaltree(root1, root2);
        if (result) {
            System.out.println("The trees are identical.");
        } else {
            System.out.println("The trees are not identical.");
        }
        
        scanner.close();
    }
}
