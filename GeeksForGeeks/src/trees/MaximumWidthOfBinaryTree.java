package trees;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidthOfBinaryTree {
    Node root;

    public static void main(String[] args) {
        MaximumWidthOfBinaryTree tree = new MaximumWidthOfBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(3);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(5);
        tree.root.left.right = new Node(3);
        tree.root.right.right = new Node(9);
        System.out.println(tree.widthOfBinaryTree(tree.root));

        MaximumWidthOfBinaryTree tree1 = new MaximumWidthOfBinaryTree();
        tree1.root = new Node(1);
        tree1.root.left = new Node(3);
        tree1.root.left.left = new Node(5);
        tree1.root.left.right = new Node(3);
        System.out.println(tree.widthOfBinaryTree(tree1.root));

        MaximumWidthOfBinaryTree tree2 = new MaximumWidthOfBinaryTree();
        tree2.root = new Node(1);
        tree2.root.left = new Node(3);
        tree2.root.right = new Node(2);
        tree2.root.left.left = new Node(5);
        System.out.println(tree.widthOfBinaryTree(tree2.root));

        MaximumWidthOfBinaryTree tree3 = new MaximumWidthOfBinaryTree();
        tree3.root = new Node(1);
        tree3.root.left = new Node(3);
        tree3.root.right = new Node(2);
        tree3.root.left.left = new Node(5);
        tree3.root.left.left.left = new Node(6);
        tree3.root.right.right = new Node(9);
        tree3.root.right.right.right = new Node(7);
        System.out.println(tree.widthOfBinaryTree(tree3.root));
    }

    public int widthOfBinaryTree(Node root) {
        int maxWidth = 0;

        Queue<Node> Q = new LinkedList<>();
        Q.add(root);
        while (!Q.isEmpty()) {
            int count = Q.size();

            maxWidth = Math.max(count, maxWidth);

            while (count-- > 0) {
                Node temp = Q.poll();
                if (temp != null && !isLeafNode(temp)) {
                    Q.add(temp.left);
                    Q.add(temp.right);
                }
            }
        }
        return maxWidth;
    }

    private boolean isLeafNode(Node temp) {
        return (temp.left == null && temp.right == null);
    }

    public int widthOfBinaryTree1(Node root) {
        if (root == null) return 0;

        int maxWidth = 0;
        Queue<Pair<Node, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair(root, 0));
        while (!queue.isEmpty()) {
            Pair<Node, Integer> first = queue.peek();
            int size = queue.size();
            Pair<Node, Integer> curr = null;
            while (size-- > 0) {
                curr = queue.poll();
                Node node = curr.getKey();
                int index = curr.getValue();
                if (node.left != null) queue.offer(new Pair(node.left, 2 * index));
                if (node.right != null) queue.offer(new Pair(node.right, 2 * index + 1));
            }
            maxWidth = Math.max(maxWidth, curr.getValue() - first.getValue() + 1);
        }

        return maxWidth;
    }
}
