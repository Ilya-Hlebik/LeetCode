package TopInterview150.Chapter_4_Matrix.lc_05_289_Game_of_Life;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public void gameOfLife(int[][] board) {
        List<int[]> deadBecameAlive = new ArrayList<>();
        List<int[]> aliveBecameDead = new ArrayList<>();
        List<int[]> options = List.of(new int[]{-1, 0}, new int[]{-1, 1}, new int[]{0, 1}, new int[]{1, 1}, new int[]{1, 0}, new int[]{1, -1}, new int[]{0, -1}, new int[]{-1, -1});
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int neighborsCount = 0;
                for (int[] option : options) {
                    if (i + option[0] < board.length && i + option[0] >= 0 && j + option[1] < board[i].length && j + option[1] >= 0 && board[i + option[0]][j + option[1]] == 1) {
                        neighborsCount++;
                    }
                }
                if (neighborsCount == 3 && board[i][j] == 0) {
                    deadBecameAlive.add(new int[]{i, j});
                } else if ((neighborsCount < 2 || neighborsCount > 3) && board[i][j] == 1) {
                    aliveBecameDead.add(new int[]{i, j});
                }
            }
        }
        for (int[] ints : deadBecameAlive) {
            board[ints[0]][ints[1]] = 1;
        }
        for (int[] ints : aliveBecameDead) {
            board[ints[0]][ints[1]] = 0;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        Solution solution = new Solution();
        solution.gameOfLife(matrix);
    }
}
