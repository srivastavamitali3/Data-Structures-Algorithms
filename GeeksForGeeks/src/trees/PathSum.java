package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 */
public class PathSum {
    public static void main(String[] args) {
        PathSum oj = new PathSum();
        boolean result = oj.isValid("");
        System.out.println(result);
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return sum == 0;
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }
        return hasPathSum(root.left, sum - root.val) ||
                hasPathSum(root.right, sum - root.val);
    }

    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        if (s.length() == 1)
            return false;
        for (int i = 0; i < s.length(); i++) {
            if (st.isEmpty())
                st.push(s.charAt(i));
            else {
                if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[')
                    st.push(s.charAt(i));
                else if (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']' && !st.isEmpty()) {
                    char c = st.peek();
                    System.out.println("c:" + c);
                    System.out.println("curr:" + s.charAt(i));

                    if (s.charAt(i) == ')' && c != '(' || s.charAt(i) == '}' && c != '{' || s.charAt(i) == ']' && c != '[')
                        return false;
                    else {
                        st.pop();
                    }
                }
            }
        }
        if (!st.isEmpty())
            return false;
        return true;
    }
}
