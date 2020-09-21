package graphs;

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {{'o', 'a', 'a', 'n'},
                {'e', 't', 'a', 'e'},
                {'i', 'h', 'k', 'r'},
                {'i', 'f', 'l', 'v'}};
        System.out.println(new WordSearch().exist(board,"oath"));
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        char[] array = word.toCharArray();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == array[0] &&
                        dfs(board, i, j, m, n, 0, array)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int i, int j,
                        int m, int n, int cur, char[] word) {
        if (cur == word.length) {
            return true;
        }
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != word[cur]) {
            return false;
        }
        char tmp = board[i][j];
        board[i][j] = '#';
        boolean ans = dfs(board, i - 1, j, m, n, cur + 1, word) ||
                dfs(board, i + 1, j, m, n, cur + 1, word) ||
                dfs(board, i, j - 1, m, n, cur + 1, word) ||
                dfs(board, i, j + 1, m, n, cur + 1, word);
        board[i][j] = tmp;
        return ans;
    }
}
