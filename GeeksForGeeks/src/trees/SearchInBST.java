package trees;

import java.util.LinkedList;
import java.util.Queue;

public class SearchInBST {
    public static void main(String[] args) {
        SearchInBST obj = new SearchInBST();
        Node root = null;
        root = insert(root, 4);
        insert(root, 2);
        insert(root, 7);
        insert(root, 1);
        insert(root, 3);

        Node data = obj.searchBST(root, 2);
        System.out.println(data.data);
    }

    static Node insert(Node Node, int data) {
        /* If the tree is empty, return a new Node */
        if (Node == null)
            return new Node(data);

        /* Otherwise, recur down the tree */
        if (data < Node.data)
            Node.left = insert(Node.left, data);
        else if (data > Node.data)
            Node.right = insert(Node.right, data);

        /* return the (unchanged) Node pointer */
        return Node;
    }

    public Node searchBST(Node root, int val) {
        if (root == null)
            return null;
        Queue<Node> Q = new LinkedList<>();
        Q.add(root);
        while (!Q.isEmpty()) {
            int temp = root.data;

            if (temp == val)
                return root;
            if (temp < val)
                root = root.right;
            if (temp > val)
                root = root.left;
            else
                return null;
        }

        return root;
    }
}
