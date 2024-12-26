package Top100Liked.Chapter_1_BackTracking.lc_07_79_Word_Search;

public class Solution {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    if (dfs(board, word, 0, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int index, int i, int j) {
        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1 || board[i][j] == '-' || word.charAt(index) != board[i][j]) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '-';
        boolean result = index == word.length() - 1
                || dfs(board, word, index + 1, i - 1, j)
                || dfs(board, word, index + 1, i, j + 1)
                || dfs(board, word, index + 1, i + 1, j)
                || dfs(board, word, index + 1, i, j - 1);
        board[i][j] = temp;
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        /*
         * [["A","B","C","E"],
         * ["S","F","C","S"],
         * ["A","D","E","E"]]
         *
         * */
        System.out.println(solution.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "ABCB"));
    }
}
