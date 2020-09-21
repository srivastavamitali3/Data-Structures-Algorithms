package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ClosestBinarySearchTree {
    TreeNode root;

    public static void main(String[] args) {

        ClosestBinarySearchTree tree1 = new ClosestBinarySearchTree();
        tree1.root = new TreeNode(4);
        tree1.root.left = new TreeNode(2);
        tree1.root.right = new TreeNode(5);
        tree1.root.left.left = new TreeNode(1);
        tree1.root.left.right = new TreeNode(3);
        //   System.out.println(tree1.closestValue(tree1.root, 3.714286));

        System.out.println(tree1.shortestDistance(new String[]{"a", "a", "b", "b"},
                "a", "b"));
    }

    public int closestValue(TreeNode root, double target) {
        int val, closestNumber = root.val;
        while (root != null) {
            val = root.val;
            closestNumber = Math.abs(val - target) < Math.abs(closestNumber - target) ? val : closestNumber;
            root = target < root.val ? root.left : root.right;
        }
        return closestNumber;
    }

    public int shortestDistance(String[] words, String word1, String word2) {
        int shortDist = words.length - 1;
        int index1 = -1, index2 = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equalsIgnoreCase(word1))
                index1 = i;
            else if (words[i].equalsIgnoreCase(word2))
                index2 = i;
            if (index1 != -1 && index2 != -1) {
                shortDist = Math.min(shortDist, Math.abs(index1 - index2));
            }
        }
        return shortDist;
    }
   /* ["a","a","b","b"]
            "a"
            "b*/
}
