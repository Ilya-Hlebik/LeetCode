package TopInterview150.Chapter_15_BackTracking.lc_07_79_Word_Search;

public class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, word, 0, new boolean[board.length][board[0].length], i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int index, boolean[][] used, int x, int y) {
        if (x < 0 || y < 0 || x > board.length - 1 || y > board[0].length - 1 || used[x][y] || board[x][y] != word.charAt(index)) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        used[x][y] = true;
        boolean exists = dfs(board, word, index + 1, used, x - 1, y) ||
                dfs(board, word, index + 1, used, x, y + 1) ||
                dfs(board, word, index + 1, used, x + 1, y) ||
                dfs(board, word, index + 1, used, x, y - 1);
        used[x][y] = false;
        return exists;
    }
}
