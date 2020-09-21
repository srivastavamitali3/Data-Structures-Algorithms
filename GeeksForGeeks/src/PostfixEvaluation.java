import java.util.Scanner;
import java.util.Stack;

public class PostfixEvaluation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            postfixEval(s);
        }
    }

    private static void postfixEval(String s) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char no = s.charAt(i);
            if (Character.isDigit(no))
                st.push(no - '0');
            else {
                int val1 = st.pop();
                int val2 = st.pop();
                switch (no) {
                    case '+':
                        st.push(val2 + val1);
                        break;

                    case '-':
                        st.push(val2 - val1);
                        break;

                    case '/':
                        st.push(val2 / val1);
                        break;

                    case '*':
                        st.push(val2 * val1);
                        break;
                }
            }
        }
        System.out.println(st.pop());
    }
}
