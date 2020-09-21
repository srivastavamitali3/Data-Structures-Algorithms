package trees;

/**
 * Given the root of a binary tree, find the maximum average value of any subtree of that tree.
 *
 * (A subtree of a tree is any node of that tree plus all its descendants.
 * The average value of a tree is the sum of its values, divided by the number of nodes.)
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: [5,6,1]
 * Output: 6.00000
 * Explanation:
 * For the node with value = 5 we have an average of (5 + 6 + 1) / 3 = 4.
 * For the node with value = 6 we have an average of 6 / 1 = 6.
 * For the node with value = 1 we have an average of 1 / 1 = 1.
 * So the answer is 6 which is the maximum.
 */
public class MaximumAverageSubTree {
    public static void main(String[] args) {

    }

    double avgRes = Double.MIN_VALUE;
    public double maximumAverageSubtree(TreeNode root) {
        dfs(root);
        return avgRes;
    }

    private int[] dfs(TreeNode root){
        if(root == null)
            return new int[]{0,0};

        int[] lST = dfs(root.left);
        int[] rST = dfs(root.right);

        int sum = lST[0] + rST[0] + root.val;
        int count = lST[1] + rST[1] + 1;

        avgRes = Math.max(1.0 * sum /count , avgRes);
        return new int[]{sum,count};
    }
}
