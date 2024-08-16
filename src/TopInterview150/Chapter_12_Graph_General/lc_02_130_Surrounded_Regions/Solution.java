package TopInterview150.Chapter_12_Graph_General.lc_02_130_Surrounded_Regions;

public class Solution {
    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O' && (i == board.length - 1 || i == 0 || j == 0 || j == board[i].length - 1)) {
                    dfs(board, i, j);
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(char[][] board, int x, int y) {
        if (x < 0 || y < 0 || x > board.length - 1 || y > board[x].length - 1 || board[x][y] != 'O') {
            return;
        }
        board[x][y] = 'T';
        dfs(board, x - 1, y);
        dfs(board, x, y + 1);
        dfs(board, x + 1, y);
        dfs(board, x, y - 1);
    }

    public static void main(String[] args) {
        char[][] board = {
                {'O', 'O', 'O', 'O', 'X', 'X'},
                {'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'O'},
                {'O', 'X', 'O', 'O', 'X', 'O'},
                {'O', 'X', 'O', 'X', 'O', 'O'},
                {'O', 'X', 'O', 'O', 'O', 'O'}
        };
        Solution solution = new Solution();
        solution.solve(board);
        System.out.println();
    }
}
