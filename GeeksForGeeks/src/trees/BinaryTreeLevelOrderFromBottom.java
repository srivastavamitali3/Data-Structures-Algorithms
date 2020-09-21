package trees;

import java.util.*;

public class BinaryTreeLevelOrderFromBottom {
    Node root;

    public static void main(String[] args) {
        BinaryTreeLevelOrderFromBottom tree = new BinaryTreeLevelOrderFromBottom();
        tree.root = new Node(3);
        tree.root.left = new Node(9);
        tree.root.right = new Node(20);
        tree.root.right.left = new Node(15);
        tree.root.right.right = new Node(7);
        List<List<Integer>> result = tree.levelOrderBottom(tree.root);
        //  System.out.println(result);
        // result.stream().forEach((x) -> x.stream().forEach(System.out::print));
    }

    public List<List<Integer>> levelOrderBottom(Node root) {
        if (root == null)
            return null;
        Queue<Node> Q = new LinkedList<>();
        List<List<Integer>> llist = new ArrayList<>();
        Q.add(root);

        while (!Q.isEmpty()) {

            int size = Q.size();
            List<Integer> level = new ArrayList();

            while (size-- > 0) {
                root = Q.poll();
                level.add(root.data);
                if (root.left != null)
                    Q.add(root.left);
                if (root.right != null)
                    Q.add(root.right);
            }
            llist.add(level);
            // System.out.println(level);
        }
        Collections.reverse(llist);
        int n = llist.size();
        while (n-- > 0)
            System.out.println("Level " + n + ":" + llist.get(n));
        return llist;
    }
}
