package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * <p>
 * Return all possible palindrome partitioning of s.
 * <p>
 * Sample Input: "aab"
 * Output:
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 */
public class PalindromePartitioning {
    public static void main(String[] args) {
        System.out.println(new PalindromePartitioning().partition("aab"));
        System.out.println(new PalindromePartitioning().partition("aaabaa"));
    }

    private List<List<String>> partition(String str) {
        List<List<String>> result = new ArrayList<>();

        if ("".equals(str) || str == null) {
            result.add(new ArrayList<>());
            return result;
        }

        dfs(str, 0, new ArrayList<>(), result);

        return result;
    }

    private void dfs(String str, int offset, List<String> palindromeStrings, List<List<String>> result) {
        if (offset == str.length()) {
            result.add(new ArrayList<>(palindromeStrings));
            return;
        }

        int currentLen = palindromeStrings.size();
        for (int i = offset; i < str.length(); i++) {
            if (isPalindrome(str, offset, i)) {
                palindromeStrings.add(str.substring(offset, i + 1));
                dfs(str, i + 1, palindromeStrings, result);
                palindromeStrings.remove(currentLen);
            }
        }
    }

    private boolean isPalindrome(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start) != str.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}
