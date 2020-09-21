package dynamicProgramming;

public class BasicRegexParser {
    public static void main(String[] args) {
        Solution obj = new Solution();
        System.out.println(obj.isMatch("aa", "a"));
        System.out.println(obj.isMatch("aa", "aa"));
        System.out.println(obj.isMatch("abc", "a.c"));
        System.out.println(obj.isMatch("abbb", "ab*"));
        System.out.println(obj.isMatch("acd", "ab*c."));
    }
}

class Solution {
    Boolean[][] dp;

    public boolean isMatch(String s, String p) {
        dp = new Boolean[s.length() + 1][p.length() + 1];
        return isMatch(s, p, 0, 0);
    }

    public boolean isMatch(String s, String p, int i, int j) {
        int m = s.length();
        int n = p.length();
        if (i == m && j == n)
            return true;
        if (j == n)
            return false;

        if (dp[i][j] != null)
            return dp[i][j];
        char ch = p.charAt(j);
        // Consider * case.
        if (j != n - 1 && p.charAt(j + 1) == '*') {
            if (isMatch(s, p, i, j + 2)) {
                dp[i][j] = true;
                return true;
            } // matching empty string.
            for (int k = i + 1; k <= m; k++) {
                if (s.charAt(k - 1) != ch && ch != '.') break;
                if (isMatch(s, p, k, j + 2)) {
                    dp[i][j] = true;
                    return true;
                }
            }

            dp[i][j] = false;
            return false;
        } else if (i != m && (ch == '.' || ch == s.charAt(i))) {
            dp[i][j] = isMatch(s, p, i + 1, j + 1);
            return dp[i][j];
        } else {
            dp[i][j] = false;
            return false;
        }
    }
}
