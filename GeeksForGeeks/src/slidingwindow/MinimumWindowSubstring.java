package slidingwindow;

/**
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 * <p>
 * Example:
 * <p>
 * Input: S = "ADOBECODEBANC", T = "ABC"
 * Output: "BANC"
 */
public class MinimumWindowSubstring {
    public static void main(String[] args) {

        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }

    public static String minWindow(String s, String t) {
        if (t.length() > s.length())
            return "";

        int low = 0, count = 0;
        int minLen = Integer.MAX_VALUE;
        String res = "";
        int[] charCountOfStringT = new int[256];
        for (char c : t.toCharArray())
            charCountOfStringT[c]++;

        //count variable keeps track if all the characters from string T are present in the selected window
        for (int high = 0; high < s.length(); high++) {
            if (--charCountOfStringT[s.charAt(high)] >= 0)
                count++;
            /**
             * start reducing the window size from left till an element from T string is not encountered
             * and the code will only satisfy the (--letterCountForStringT[s.charAt(right)] >= 0) condition
             * when another instance of the removed character is encountered in the window and then only renter the while loop
             */
            while (count == t.length()) {
                if (minLen > high - low + 1) {
                    minLen = high - low + 1;
                    res = s.substring(low, high + 1);
                }
                if (++charCountOfStringT[s.charAt(low)] > 0)
                    count--;
                low++;
            }
        }
        return res;
    }
}
