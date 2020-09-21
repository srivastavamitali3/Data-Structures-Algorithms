package graphs;

import java.util.*;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list,
 * find the length of shortest transformation sequence from beginWord to endWord, such that:
 * <p>
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list.
 * Note:
 * <p>
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * Example 1:
 * <p>
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * Output: 5
 * <p>
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * Example 2:
 * <p>
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * Output: 0
 * <p>
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */
public class WordLadder {
    public static void main(String[] args) {
        System.out.println(new WordLadder().ladderLength("hit", "cog",
                Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"})));
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dictionary = new HashSet<>(wordList);
        int level = 1;
        Queue<String> Q = new LinkedList<>();
        Q.add(beginWord);
        while (!Q.isEmpty()) {
            int size = Q.size();
            for (int k = 0; k < size; k++) {
                char[] curr = Q.poll().toCharArray();
                for (int i = 0; i < curr.length; i++) {
                    char temp = curr[i];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        curr[i] = ch;
                        String dest = new String(curr);
                        if (dictionary.contains(dest)) {
                            if (dest.equals(endWord))
                                return level + 1;
                            Q.add(dest);
                            dictionary.remove(dest);
                        }
                    }
                    curr[i] = temp;
                }
            }
            level++;
        }
        return 0;
    }
}
