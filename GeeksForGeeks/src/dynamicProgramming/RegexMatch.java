package dynamicProgramming;

public class RegexMatch {
    public static void main(String[] args) {
        RegexMatch obj = new RegexMatch();
        System.out.println(obj.isMatch("","a*"));

    }

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
                if (s.charAt(k - 1) != ch && ch != '.')
                    break;
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


/*1, If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
2, If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
3, If p.charAt(j) == '*':
    here are two sub conditions:
            1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
            2   if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
    dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a
    or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
    or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty*/
}
