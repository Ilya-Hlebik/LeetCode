package TopInterview150.Chapter_12_Graph_General.lc_02_130_Surrounded_Regions;

public class Solution {
    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }
    }

    public boolean dfs(char[][] board, int x, int y) {
        if (x < 0 || y < 0 || x > board.length - 1 || y > board[x].length - 1 || board[x][y] == 'X') {
            return true;
        }
        if ((x == board.length - 1 || x == 0 || y == 0 || y == board[x].length - 1) && board[x][y] != 'X') {
            return false;
        }
        board[x][y] = '-';
        if ( dfs(board, x - 1, y) &&
                dfs(board, x, y + 1) &&
                dfs(board, x + 1, y) &&
                dfs(board, x, y - 1) ) {
            board[x][y] = 'X';
            return true;
        }
        else {
            board[x][y] = 'O';
            return false;
        }
    }
}
