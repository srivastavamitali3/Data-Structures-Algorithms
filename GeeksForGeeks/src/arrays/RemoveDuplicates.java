package arrays;

import java.util.Stack;

public class RemoveDuplicates {
    public static void main(String[] args) {
        System.out.println(new RemoveDuplicates().removeDuplicates("abbaca"));
        System.out.println(Math.ceil(-1.2));
    }

   /* public String removeDuplicates(String S) {
        Stack<Character> st = new Stack<>();
        String result = "";
        for (int i = 0; i < S.length(); i++) {
            if (!st.isEmpty() && st.peek() == S.charAt(i))
                st.pop();
            else
                st.push(S.charAt(i));
        }
        while (!st.isEmpty()) {
            result += st.pop();
        }
        StringBuilder sb = new StringBuilder(result);
        sb.reverse();
        return sb.toString();
    }*/

    /*public String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder(S);
        int i = 1;
        while (i < sb.length()) {
            if (sb.charAt(i) == sb.charAt(i - 1)) {
                sb.delete(i - 1, i + 1);
                if (i > 1) i = i - 1;
            }
            else
                i++;
        }
        return sb.toString();
    }*/
    public String removeDuplicates(String S) {
        int i = 0, n = S.length();
        char[] res = new char[n];
        for (int j = 0; j < n; ++j, ++i) {
            res[i] = S.charAt(j);
            if (i > 0 && res[i - 1] == res[i]) // count = 2
                i -= 2;
        }
        return new String(res, 0, i);
    }

}
