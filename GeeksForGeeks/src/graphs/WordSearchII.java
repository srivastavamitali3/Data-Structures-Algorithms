package graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 * <p>
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent"
 * cells are those horizontally or vertically neighboring. The same letter cell may not be used
 * more than once in a word.
 * <p>
 * Example:
 * <p>
 * Input:
 * board = [
 * ['o','a','a','n'],
 * ['e','t','a','e'],
 * ['i','h','k','r'],
 * ['i','f','l','v']
 * ]
 * words = ["oath","pea","eat","rain"]
 * <p>
 * Output: ["eat","oath"]
 */
public class WordSearchII {
    public static void main(String[] args) {
        char[][] board = {{'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}};
        String[] words = {"oath", "pea", "eat", "rain"};
        System.out.println(new WordSearchII().findWords(board, words));
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();

        if (board.length == 0 || words.length == 0)
            return result;

        int row = board.length;
        int col = board[0].length;

        for (String word : words) {
            char[] w = word.toCharArray();
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++)
                    if (board[i][j] == w[0] && dfs(board, i, j, row, col, 0, w))
                        if (!result.contains(word))
                            result.add(word);
            }
        }
        Collections.sort(result);
        return result;
    }

    private boolean dfs(char[][] board, int i, int j, int row, int col, int curr, char[] word) {
        if (curr == word.length)
            return true;
        if (i < 0 || i >= row || j < 0 || j >= col || board[i][j] != word[curr])
            return false;

        char temp = board[i][j];
        board[i][j] = '#';
        boolean ans = dfs(board, i - 1, j, row, col, curr + 1, word) ||
                dfs(board, i + 1, j, row, col, curr + 1, word) ||
                dfs(board, i, j - 1, row, col, curr + 1, word) ||
                dfs(board, i, j + 1, row, col, curr + 1, word);
        board[i][j] = temp;
        return ans;
    }
}
