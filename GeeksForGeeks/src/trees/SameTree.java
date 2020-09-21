package trees;

public class SameTree {
    TreeNode root;

    public static void main(String[] args) {
        SameTree tree = new SameTree();
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(3);
        tree.root.right = new TreeNode(2);

        SameTree tree1 = new SameTree();
        tree1.root = new TreeNode(1);
        tree1.root.left = new TreeNode(4);
        tree1.root.right = new TreeNode(2);

        System.out.println(tree.isSameTree(tree.root, tree1.root));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p != null && q != null)
            return (p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
        return false;
    }


}
