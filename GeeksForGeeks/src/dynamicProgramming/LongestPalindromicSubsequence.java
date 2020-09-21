package dynamicProgramming;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubsequence().longestPalindrome("bbbab"));
    }

    public int longestPalindrome(String s) {
        StringBuffer sb = new StringBuffer(s);
        String s2 = sb.reverse().toString();
        return longestPalindromeSubstring(s, s2, s.length(), s2.length());
    }

    private int longestPalindromeSubstring(String s1, String s2, int lengthOfs1, int lengthOfs2) {
        int[][] table = new int[lengthOfs1 + 1][lengthOfs2 + 1];

        for (int i = 0; i < lengthOfs1 + 1; i++)
            for (int j = 0; j < lengthOfs2 + 1; j++)
                if (i == 0 || j == 0)
                    table[i][j] = 0;

        for (int i = 1; i < lengthOfs1 + 1; i++) {
            for (int j = 1; j < lengthOfs2 + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    table[i][j] = 1 + table[i - 1][j - 1];
                else
                    table[i][j] = Math.max(table[i][j-1], table[i-1][j]);
            }
        }
        return table[lengthOfs1][lengthOfs2];
    }
}
