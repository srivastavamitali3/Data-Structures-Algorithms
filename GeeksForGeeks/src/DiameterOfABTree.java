import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class DiameterOfABTree {
    public static void main(String args[]) throws IOException {
        // Input the number of test cases you want to run
        // Scanner sc = new Scanner(System.in);
        // int t = sc.nextInt();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t > 0) {
            HashMap<Integer, Node> m = new HashMap<Integer, Node>();
            int n = Integer.parseInt(read.readLine());
            Node root = null;
            int k = 0;
            String str[] = read.readLine().trim().replace("  ", " ").split(" ");
            for (k = 0; k < n * 3; ) {
                int n1 = Integer.parseInt(str[k++]);
                int n2 = Integer.parseInt(str[k++]);
                char lr = str[k++].charAt(0);
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

            }
            System.out.println(diameter(root));
            System.out.println(res);
            t--;
        }
    }

    static int res = 0;

    private static int diameter(Node root) {
        if (root == null)
            return 0;
        /*int lHeight = height(root.left);
        int rHeight = height(root.right);*/

        int lDiameter = diameter(root.left);
        int rDiameter = diameter(root.right);
        res = Math.max(res, lDiameter + rDiameter + 1);
        return Math.max(lDiameter, rDiameter) + 1;
    }

    private static int height(Node root) {
        if (root == null)
            return 0;

        return (1 + Math.max(height(root.left), height(root.right)));
    }
}
