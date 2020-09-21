package graphs;

import java.util.*;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 *
 * Note:
 *
 * The same word in the dictionary may be reused multiple times in the segmentation.
 * You may assume the dictionary does not contain duplicate words.
 * Example 1:
 *
 * Input: s = "leetcode", wordDict = ["leet", "code"]
 * Output: true
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * Example 2:
 *
 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
 * Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
 *              Note that you are allowed to reuse a dictionary word.
 * Example 3:
 *
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 */
public class WordBreak {
    public static void main(String[] args) {
        System.out.println(new WordBreak().wordBreak1("leetcode", Arrays.asList(new String[]{"leet", "code"})));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dictSet = new HashSet<>(wordDict);
        Queue<Integer> Q = new LinkedList<>();
        boolean[] visited = new boolean[s.length() + 1];
        Q.add(0);
        while (!Q.isEmpty()) {
            int start = Q.poll();
            if (!visited[start]) {
                for (int end = start + 1; end <= s.length(); end++) {
                    if (dictSet.contains(s.substring(start, end))) {
                        Q.add(end);
                        if (end == s.length())
                            return true;
                    }
                }
                visited[start] = true;
            }
        }
        return false;
    }

    public boolean wordBreak1(String s, List<String> wordDict) {
        if(s.length() > 100)
            return false;
        return DFS(s, wordDict);
    }

    public boolean DFS(String s, List<String> wordDict){
        for(String word : wordDict){
            if(s.startsWith(word) && (s.equals(word) || DFS(s.substring(word.length()), wordDict)))
                return true;
        }
        return false;
    }
}
