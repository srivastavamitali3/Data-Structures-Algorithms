
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class ConvertSortedArrayToBST {
    public static void main(String[] args) {
        int[] arr = new int[]{-10, -3, 0, 5, 9};
        TreeNode node = sortedArrayToBst(arr);
        printInorder(node);
        //[0,-3,9,-10,null,5]
    }

    private static void printInorder(TreeNode node) {
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.val + " ");
        printInorder(node.right);
    }

    private static TreeNode sortedArrayToBst(int[] arr) {

        return makeBST(arr, 0, arr.length - 1);
    }

    private static TreeNode makeBST(int[] arr, int low, int high) {
        if (low > high)
            return null;
        int mid = low + (high - low) / 2;
        TreeNode node = new TreeNode(arr[mid]);
        node.left = makeBST(arr, low, mid - 1);
        node.right = makeBST(arr, mid + 1, high);
        return node;
    }
}
