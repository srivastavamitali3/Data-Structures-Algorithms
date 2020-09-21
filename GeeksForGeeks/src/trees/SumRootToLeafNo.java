package trees;

public class SumRootToLeafNo {
    public static void main(String[] args) {

    }

    public int sumNumbers(Node root) {
        if (root == null)
            return 0;

        if (root.left == null && root.right == null)
            return root.data;

        int sum = 0;

        return sum;
    }
}
