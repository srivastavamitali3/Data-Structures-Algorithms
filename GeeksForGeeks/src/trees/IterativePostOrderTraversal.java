package trees;

import java.util.Stack;

public class IterativePostOrderTraversal {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        iterativePostorder(root);
    }

    private static void iterativePostorder(Node root) {
        class Pair {
            Node node;
            int data;

            Pair(Node node, int data) {
                this.node = node;
                this.data = data;
            }
        }
        if (root == null)
            return;
        Stack<Pair> st = new Stack<>();
        st.push(new Pair(root, 0));
        while (!st.isEmpty()) {
            Node temp = st.peek().node;
            int data = st.peek().data;
            st.pop();
            if (temp == null)
                continue;
            if (data == 0) {
                st.push(new Pair(temp, 1));
                if (temp.left != null)
                    st.push(new Pair(temp.left, 0));
            } else if (data == 1) {
                st.push(new Pair(temp, 2));
                if (temp.right != null)
                    st.push(new Pair(temp.right, 0));
            } else
                System.out.print(temp.data + " ");

        }

    }
}
