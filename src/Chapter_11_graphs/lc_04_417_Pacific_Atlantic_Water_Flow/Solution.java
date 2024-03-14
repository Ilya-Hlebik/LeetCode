package Chapter_11_graphs.lc_04_417_Pacific_Atlantic_Water_Flow;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        };
        System.out.println(solution.pacificAtlantic(arr));
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[i].length; j++) {
                dfs(heights, i, j, result, new Pair(i, j), heights[i][j], new HashSet<>());
            }
        }
        return result;
    }

    private void dfs(int[][] heights, int i, int j, List<List<Integer>> result, Pair pair, int previous, Set<Map.Entry<Integer, Integer>> visited) {
        if (pair.flowToBoth() || i < 0 || j < 0 || i > heights.length - 1 || j > heights[0].length - 1 || heights[i][j] > previous || visited.contains(Map.entry(i, j))) {
            return;
        }
        Map.Entry<Integer, Integer> entry = Map.entry(i, j);
        visited.add(entry);
        pair.isAtlantic = pair.isAtlantic || isAtlantic(heights, i, j);
        pair.isPacific =   pair.isPacific || isPacific(i, j);
        if (pair.flowToBoth()) {
            result.add(List.of(pair.i, pair.j));
            return;
        }
        dfs(heights, i - 1, j, result, pair, heights[i][j], visited);
        dfs(heights, i, j + 1, result, pair, heights[i][j], visited);
        dfs(heights, i + 1, j, result, pair, heights[i][j], visited);
        dfs(heights, i, j - 1, result, pair, heights[i][j], visited);
        visited.remove(entry);
    }

    private boolean isPacific(int i, int j) {
        return i == 0 || j == 0;
    }

    private boolean isAtlantic(int[][] heights, int i, int j) {
        return j == heights[0].length - 1 || i == heights.length - 1;
    }
}

class Pair {
    public int i;
    public int j;
    public boolean isPacific;
    public boolean isAtlantic;

    public Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public boolean flowToBoth() {
        return isAtlantic && isPacific;
    }
}
