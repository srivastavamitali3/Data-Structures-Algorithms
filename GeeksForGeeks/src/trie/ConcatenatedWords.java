package trie;

import java.util.ArrayList;
import java.util.List;

public class ConcatenatedWords {
    public static void main(String[] args) {
        String words[] = {"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"};
        System.out.println(new ConcatenatedWords().findAllConcatenatedWordsInADict(words));
    }

    static WordNode root;

    static class WordNode {
        WordNode[] children;
        boolean isEndOfWord;

        WordNode() {
            isEndOfWord = false;
            children = new WordNode[26];
        }
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        if (words == null || words.length == 0)
            return new ArrayList<>();

        List<String> res = new ArrayList<>();
        root = new WordNode();

        for (String word : words)
            insertWords(word);

        for (String word : words) {
            if (searchConcatWords(word, 0, 0))
                res.add(word);
        }

        return res;
    }

    private void insertWords(String word) {
        int level, len = word.length(), index;
        WordNode pCrawl = root;
        for (level = 0; level < len; level++) {
            index = word.charAt(level) - 'a';
            if (pCrawl.children[index] == null)
                pCrawl.children[index] = new WordNode();

            pCrawl = pCrawl.children[index];
        }
        pCrawl.isEndOfWord = true;
    }

    private boolean searchConcatWords(String word, int startIndex, int countConcatedWords) {
        if (startIndex == word.length())
            return countConcatedWords >= 2;

        int level, len = word.length(), index;
        WordNode pCrawl = root;

        for (level = startIndex; level < len; level++) {
            index = word.charAt(level) - 'a';
            if (pCrawl.children[index] == null)
                return false;

            pCrawl = pCrawl.children[index];

            if (pCrawl != null && pCrawl.isEndOfWord)
                if (searchConcatWords(word, level + 1, countConcatedWords + 1))
                    return true;
        }
        return false;
    }

}
