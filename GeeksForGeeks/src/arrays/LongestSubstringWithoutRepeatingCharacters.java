package arrays;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(isPalindrome(-121));
    }

    private static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int res = 0, i = 0, j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                res = Math.max(res, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return res;
    }

    public static boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int n = s.length();
        String str = "";
        for (int i = n - 1; i >= 0; i--)
            str += s.charAt(i);
        if (str.equals(s))
            return true;

        return false;
    }
}
