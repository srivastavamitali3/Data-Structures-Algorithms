package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ZigZagTraversalOfBinaryTree {
    TreeNode root;

    public static void main(String[] args) {
        ZigZagTraversalOfBinaryTree tree = new ZigZagTraversalOfBinaryTree();
        tree.root = new TreeNode(3);
        tree.root.left = new TreeNode(9);
        tree.root.right = new TreeNode(20);
        tree.root.right.left = new TreeNode(15);
        tree.root.right.right = new TreeNode(7);

        System.out.println(tree.zigzagLevelOrder(tree.root));
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        explore(root, 0, result);
        return result;
    }

    public void explore(TreeNode root, int level, List<List<Integer>> result) {
        if (root == null)
            return;
        if (result.size() == level) {
            result.add(new ArrayList<Integer>());
        }
        if (level % 2 == 0)
            result.get(level).add(root.val);
        else
            result.get(level).add(0, root.val);
        explore(root.left, level + 1, result);
        explore(root.right, level + 1, result);
    }
}
