package Top100Liked.Chapter_4_Dynamic_Programming.lc_11_118_279_Perfect_Squares;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int numSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        int current = 0;
        for (int i = 1; current <= n; i++) {
            current = i * i;
            squares.add(current);
        }
        return dfs(squares, n, new Integer[n + 1]);
    }

    public int dfs(List<Integer> squares, int n, Integer[] memo) {
        if (n == 0) {
            return 0;
        }
        if (n < 0) {
            return Integer.MAX_VALUE;
        }
        if (memo[n] != null) {
            return memo[n];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < squares.size(); i++) {
            int current = dfs(squares, n - squares.get(i), memo);
            if (current != Integer.MAX_VALUE) {
                min = Math.min(current + 1, min);
            }
        }
        return memo[n] = min;
    }
}
