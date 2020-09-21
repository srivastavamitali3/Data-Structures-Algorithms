package arrays;

import java.util.Scanner;

/*Test Case
*
3
3
7
100
* */
public class NthFaithfulNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NthFaithfulNumber obj = new NthFaithfulNumber();
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            System.out.println(obj.faithfulNumber(n));
        }
    }

    private long faithfulNumber(int n) {
        String s = "";
        while (n > 0) {
            int x = n % 2;
            s += x;
            n = n / 2;
        }
        long p = 0, f = 1;
        for (int i = 0; i < s.length(); i++) {
            p = p + (s.charAt(i) - 48) * f;
            f *= 7;
        }
        return p;
    }
}
