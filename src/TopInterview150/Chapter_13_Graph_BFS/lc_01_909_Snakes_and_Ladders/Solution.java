package TopInterview150.Chapter_13_Graph_BFS.lc_01_909_Snakes_and_Ladders;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        boolean[] visited = new boolean[n * n + 1];
        int move = -1;
        while (!queue.isEmpty()) {
            move++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int num = queue.poll();
                if (visited[num]) {
                    continue;
                }
                visited[num] = true;
                if (num == n * n) {
                    return move;
                }
                for (int j = 1; j <= 6 && j + num <= n * n; j++) {
                    int next = num + j;
                    int value = getBoardValue(board, next);
                    if (value > 0) {
                        next = value;
                    }
                    if (!visited[next]) {
                        queue.add(next);
                    }
                }
            }
        }
        return -1;
    }

    private int getBoardValue(int[][] board, int next) {
        int r = (next - 1) / board.length;
        int x = board.length - 1 - r;
        int y = r % 2 == 0 ? next - 1 - r * board.length : board.length + r * board.length - next;
        return board[x][y];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] board = {
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}
        };
        solution.snakesAndLadders(board);
    }
}
