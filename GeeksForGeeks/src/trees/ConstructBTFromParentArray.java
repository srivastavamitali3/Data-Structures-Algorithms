package trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ConstructBTFromParentArray {
    static ArrayList<Integer> result = new ArrayList<Integer>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];

            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();

            BinaryTreeCreation gfg = new BinaryTreeCreation();
            Node root = gfg.createTree(arr, n);

            printLevelOrder(root);
            System.out.println();
        }
    }

    public static void printList(Node root) {
        while (root != null) {
            System.out.print(root.data + " ");
        }
    }

    public static void printLevelOrder(Node root) {
        int h = height(root);
        int i;
        for (i = 1; i <= h; i++) {
            result.clear();
            printGivenLevel(root, i);
            Collections.sort(result);
            for (int j = 0; j < result.size(); j++)
                System.out.print(result.get(j) + " ");
        }
    }

    public static int height(Node root) {
        if (root == null)
            return 0;
        else {
            int lheight = height(root.left);
            int rheight = height(root.right);
            if (lheight > rheight)
                return (lheight + 1);
            else return (rheight + 1);
        }
    }

    public static void printGivenLevel(Node node, int level) {
        if (node == null)
            return;
        if (level == 1)
            result.add(node.data);
        else if (level > 1) {
            printGivenLevel(node.left, level - 1);
            printGivenLevel(node.right, level - 1);
        }
    }
}

class BinaryTreeCreation {
    Node root;

    public Node createTree(int[] arr, int n) {
        Node[] created = new Node[n];

        Arrays.fill(created, null);

        for (int i = 0; i < n; i++)
            createNodes(arr, i, created);

        return root;
    }

    private void createNodes(int[] arr, int i, Node[] created) {

        if (created[i] != null)
            return;
        created[i] = new Node(i);
        if (arr[i] == -1) {
            root = created[i];
            return;
        }
        if (created[arr[i]] == null)
            createNodes(arr, arr[i], created);
        Node p = created[arr[i]];
        if (p.left == null)
            p.left = created[i];
        else
            p.right = created[i];
    }
}
