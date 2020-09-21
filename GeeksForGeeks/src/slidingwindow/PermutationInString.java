package slidingwindow;

/**
 * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1.
 * In other words, one of the first string's permutations is the substring of the second string.
 * <p>
 * Example 1:
 * <p>
 * Input: s1 = "ab" s2 = "eidbaooo"
 * Output: True
 * Explanation: s2 contains one permutation of s1 ("ba").
 * Example 2:
 * <p>
 * Input:s1= "ab" s2 = "eidboaoo"
 * Output: False
 */
public class PermutationInString {
    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));
        System.out.println(checkInclusion("ab", "eidboaoo"));
    }

    public static boolean checkInclusion(String s1, String s2) {

        int[] charCountOfTargetString = new int[256];
        for (char c : s1.toCharArray())
            charCountOfTargetString[c]++;

        int low = 0;
        int count = 0;

        for (int high = 0; high < s2.length(); high++) {
            if (--charCountOfTargetString[s2.charAt(high)] >= 0)
                count++;
            while (count == s1.length()) {
                if (high - low + 1 == s1.length())
                    return true;
                if (++charCountOfTargetString[s2.charAt(low)] > 0)
                    count--;
                low++;
            }
        }

        return false;
    }
}
