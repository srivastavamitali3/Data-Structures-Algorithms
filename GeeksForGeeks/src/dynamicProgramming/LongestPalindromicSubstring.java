package dynamicProgramming;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * <p>
 * Example 1:
 * <p>
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 * <p>
 * Input: "cbbd"
 * Output: "bb"
 */
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("cbbd"));
        System.out.println(new LongestPalindromicSubstring().longestPalindrome("babad"));
        System.out.println(new LongestPalindromicSubstring().longestPalindrome(""));
    }

    /*public String longestPalindrome(String s) {
        if (s == "" || s.length() < 0)
            return "";

        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandaroundcenter(s, i, i);
            int len2 = expandaroundcenter(s, i, i + 1);
            int maxLen = Math.max(len1, len2);
            if (maxLen > end - start) {
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }

        return s.substring(start, end + 1);

    }

    private int expandaroundcenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return right - left - 1;
    }*/

    String result = "";

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return result;
        int startIndex = 0;
        while (startIndex < s.length()) {
            startIndex = helper(s, startIndex);
        }
        return result;
    }

    private int helper(String s, int startIndex) {
        int firstDiff = startIndex + 1;
        while (firstDiff < s.length()
                && s.charAt(firstDiff) == s.charAt(startIndex)) {
            firstDiff++;
        }
        int left = startIndex - 1;
        int right = firstDiff;
        while (left >= 0 && right < s.length()
                && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        if (right - left - 1 > result.length()) {
            result = s.substring(left + 1, right);
        }
        return firstDiff;
    }
}
