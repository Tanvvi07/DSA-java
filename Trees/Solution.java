package Trees;
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class Solution {

    static class Pair {
        boolean first;
        int second;

        Pair(boolean first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    // Function to check if a tree is a Sum Tree
    Pair isSumTreeFast(Node root) {
        if (root == null)
            return new Pair(true, 0);
        if (root.left == null && root.right == null)
            return new Pair(true, root.data);

        Pair leftAns = isSumTreeFast(root.left);
        Pair rightAns = isSumTreeFast(root.right);

        boolean left = leftAns.first;
        boolean right = rightAns.first;
        boolean value = (root.data == leftAns.second + rightAns.second);

        if (left && right && value) {
            return new Pair(true, 2 * root.data);
        } else {
            return new Pair(false, 0);
        }
    }

    boolean isSumTree(Node root) {
        return isSumTreeFast(root).first;
    }

    // Build tree from user input using Scanner
    public static Node buildTreeFromInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter root value (-1 for null): ");
        int rootVal = sc.nextInt();
        if (rootVal == -1) return null;

        Node root = new Node(rootVal);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            System.out.print("Enter left child of " + current.data + " (-1 for null): ");
            int leftVal = sc.nextInt();
            if (leftVal != -1) {
                current.left = new Node(leftVal);
                queue.add(current.left);
            }

            System.out.print("Enter right child of " + current.data + " (-1 for null): ");
            int rightVal = sc.nextInt();
            if (rightVal != -1) {
                current.right = new Node(rightVal);
                queue.add(current.right);
            }
        }

        return root;
    }

    public static void main(String[] args) {
        Node root = buildTreeFromInput();
        Solution sol = new Solution();
        if (sol.isSumTree(root)) {
            System.out.println("The tree is a Sum Tree.");
        } else {
            System.out.println("The tree is NOT a Sum Tree.");
        }
    }
}

