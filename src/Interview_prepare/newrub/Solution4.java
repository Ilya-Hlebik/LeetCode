package Interview_prepare.newrub;

public class Solution4 {
    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, i, j, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1 || board[i][j] == '_' || board[i][j] != word.charAt(index)) {
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '_';
        boolean exists = dfs(board, word, i - 1, j, index + 1) || dfs(board, word, i, j + 1, index + 1)
                || dfs(board, word, i + 1, j, index + 1) || dfs(board, word, i, j - 1, index + 1);
        board[i][j] = temp;
        return exists;
    }


    public static void main(String[] args) {
        Solution4 solution4 = new Solution4();
        /*
         * [["A","B","C","E"],
         * ["S","F","C","S"],
         * ["A","D","E","E"]]
         *
         * */
        System.out.println(solution4.exist(new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}}, "SEECFF"));
    }
}
