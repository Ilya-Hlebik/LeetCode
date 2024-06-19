package TopInterview150.Chapter_4_Matrix.lc_05_289_Game_of_Life;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public void gameOfLife(int[][] board) {
        List<int[]> deadBecameAlive = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    int neighborsCount = 0;
                    if (i - 1 > 0 && board[i - 1][j] == 1) {
                        neighborsCount++;
                    }
                    if (i - 1 > 0 && j + 1 < board[i].length && board[i - 1][j + 1] == 1) {
                        neighborsCount++;
                    }
                    if (j + 1 < board[i].length && board[i][j + 1] == 1) {
                        neighborsCount++;
                    }
                    if (j + 1 < board[i].length && i + 1 < board.length && board[i + 1][j + 1] == 1) {
                        neighborsCount++;
                    }
                    if (i + 1 < board.length && board[i + 1][j] == 1) {
                        neighborsCount++;
                    }
                    if (i + 1 < board.length && j - 1 > 0 && board[i + 1][j - 1] == 1) {
                        neighborsCount++;
                    }
                    if (j - 1 > 0 && board[i][j - 1] == 1) {
                        neighborsCount++;
                    }
                    if (j - 1 > 0 && i - 1 > 0 && board[i - 1][j - 1] == 1) {
                        neighborsCount++;
                    }
                    if (neighborsCount == 3) {
                        deadBecameAlive.add(new int[]{i, j});
                    }
                }
            }
        }
    }
}
