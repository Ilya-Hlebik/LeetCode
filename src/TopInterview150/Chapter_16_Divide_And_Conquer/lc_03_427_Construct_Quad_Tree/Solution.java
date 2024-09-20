package TopInterview150.Chapter_16_Divide_And_Conquer.lc_03_427_Construct_Quad_Tree;

public class Solution {
    public Node construct(int[][] grid) {
        Node result = new Node(true, false);
        return dfs(grid, result, 0, grid.length, 0, grid[0].length);
    }

    public Node dfs(int[][] grid, Node node, int x1, int x2, int y1, int y2) {
        Boolean value = getValue(grid, x1, x2, y1, y2);
        if (value != null) {
            return new Node(value, true);
        }
        node.topLeft = dfs(grid, new Node(true, false), x1, x2 - (x2 - x1) / 2, y1, y2 - ((y2 - y1) / 2));
        node.topRight = dfs(grid, new Node(true, false), x1, x2 - (x2 - x1) / 2, y2 - ((y2 - y1) / 2), y2);
        node.bottomLeft = dfs(grid, new Node(true, false), x2 - (x2 - x1) / 2, x2, y1, y2 - ((y2 - y1) / 2));
        node.bottomRight = dfs(grid, new Node(true, false), x2 - (x2 - x1) / 2, x2, y2 - ((y2 - y1) / 2), y2);
        return node;
    }

    public Boolean getValue(int[][] grid, int x1, int x2, int y1, int y2) {
        Integer val = null;
        for (int i = x1; i < x2; i++) {
            for (int j = y1; j < y2; j++) {
                if (val == null) {
                    val = grid[i][j];
                } else {
                    if (val != grid[i][j]) {
                        return null;
                    }
                }
            }
        }
        return val == 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
       /* int[][] grid = {
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 0, 0, 0, 0}
        };*/
        int[][] grid = {
                {1, 1, 0, 0},
                {0, 0, 1, 1},
                {1, 1, 0, 0},
                {0, 0, 1, 1}
        };
        solution.construct(grid);
    }
}
