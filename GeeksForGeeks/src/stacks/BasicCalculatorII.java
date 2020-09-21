package stacks;

import java.util.Stack;

public class BasicCalculatorII {
    public static void main(String[] args) {
        System.out.println(new BasicCalculatorII().calculate("3+2*2"));
        System.out.println(new BasicCalculatorII().calculate("3/2"));
        System.out.println(new BasicCalculatorII().calculate("3+5 / 2"));
        System.out.println(new BasicCalculatorII().calculate(""));
    }

    public int calculate(String s) {
        if (s.length() < 0 || s == null)
            return 0;
        Stack<Integer> stack = new Stack<>();
        s += '+';
        char op = '+';
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                n = n * 10 + c - '0';
                continue;
            }
            if (c == ' ') continue;
            if (op == '+') stack.push(n);
            else if (op == '-') stack.push(-n);
            else if (op == '*') stack.push(stack.pop() * n);
            else if (op == '/') stack.push(stack.pop() / n);
            op = c;
            n = 0;
        }

        int total = 0;
        while (!stack.isEmpty()) total += stack.pop();
        return total;
    }
}
