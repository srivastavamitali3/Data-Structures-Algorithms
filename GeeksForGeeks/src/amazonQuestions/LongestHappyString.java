package amazonQuestions;

/*
A string is called happy if it does not have any of the strings 'aaa', 'bbb' or 'ccc' as a substring.

Given three integers a, b and c, return any string s, which satisfies following conditions:

s is happy and longest possible.
s contains at most a occurrences of the letter 'a', at most b occurrences of the letter 'b' and at most c occurrences of the letter 'c'.
s will only contain 'a', 'b' and 'c' letters.
If there is no such string s return the empty string "".
 */
public class LongestHappyString {
    public static void main(String[] args) {
        LongestHappyString lhs = new LongestHappyString();
        System.out.println(lhs.longestDiverseString(1, 1, 7));//ccbccacc
        System.out.println(lhs.longestDiverseString(2, 2, 1));//aabbc
        System.out.println(lhs.longestDiverseString(7, 1, 0));//aabaa
    }

    public String longestDiverseString(int a, int b, int c) {
        int size = a + b + c;
        StringBuilder sb = new StringBuilder();
        int[] left = new int[]{a, b, c};
        int[] preCount = new int[]{0, 0, 0};
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 3; j++) {
                int k = (j + 1) % 3;
                int l = (j + 2) % 3;
                if ((left[j] > 0 && left[j] >= left[k] && left[j] >= left[l] && preCount[j] < 2)
                        || ((preCount[k] >= 2 || preCount[l] >= 2) && left[j] > 0)) {
                    char curChar = (char) ('a' + j);
                    sb.append(curChar);
                    left[j]--;
                    preCount[j]++;
                    preCount[k] = 0;
                    preCount[l] = 0;
                    break;
                }
            }
        }
        return sb.toString();
    }

    /*public String longestDiverseString1(int a, int b, int c) {
        return generate(a, b, c, "a", "b", "c");
    }

    String generate(int a, int b, int c, String aa, String bb, String cc) {
        if (a < b)
            return generate(b, a, c, bb, aa, cc);
        if (b < c)
            return generate(a, c, b, aa, cc, bb);
        if (b == 0)
            return aa.repeat(Math.min(2, a));
        int use_a = Math.min(2, a), use_b = a - use_a >= b ? 1 : 0;
        return aa.repeat(use_a) + bb.repeat(use_b) +
                generate(a - use_a, b - use_b, c, aa, bb, cc);
    }*/
}
