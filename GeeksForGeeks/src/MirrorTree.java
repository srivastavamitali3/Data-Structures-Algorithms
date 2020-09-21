import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MirrorTree {
    void inOrder(Node node) {
        if (node == null) {
            return;
        }

        inOrder(node.left);
        System.out.print(node.data + " ");

        inOrder(node.right);
    }

    // driver function to test the above functions
    public static void main(String args[]) {
        // Input the number of test cases you want to run
        Scanner sc = new Scanner(System.in);
        MirrorTree mt = new MirrorTree();
        int t = sc.nextInt();
        while (t > 0) {
            HashMap<Integer, Node> m = new HashMap<Integer, Node>();
            int n = sc.nextInt();
            Node root = null;
            while (n > 0) {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                char lr = sc.next().charAt(0);
                //  cout << n1 << " " << n2 << " " << (char)lr << endl;
                Node parent = m.get(n1);
                if (parent == null) {
                    parent = new Node(n1);
                    m.put(n1, parent);
                    if (root == null)
                        root = parent;
                }
                Node child = new Node(n2);
                if (lr == 'L')
                    parent.left = child;
                else
                    parent.right = child;
                m.put(n2, child);
                n--;
            }
            mirror(root);
            mt.inOrder(root);
            System.out.println();
            t--;
        }
    }

    private static void mirror(Node root) {
        if (root == null)
            return;
        Queue<Node> Q = new LinkedList<>();
        Q.add(root);
        while (!Q.isEmpty()) {
            Node current = Q.poll();

            Node temp = current.left;
            current.left = current.right;
            current.right = temp;
            if (current.left != null)
                Q.add(current.left);
            if (current.right != null)
                Q.add(current.right);
        }
    }
}

