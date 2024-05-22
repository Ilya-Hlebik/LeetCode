package LeetCode75.Chapter_12_Graphs_DFS.lc_02_547_Number_of_Provinces;

public class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]){
                dfs(isConnected, i, visited);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] isConnected, int i, boolean[] visited) {
        for (int j = 0; j< isConnected[0].length; j++){
            if (!visited[j] && isConnected[i][j]!=0){
                visited[j] = true;
                dfs(isConnected, j, visited);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] array = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        System.out.println(solution.findCircleNum(array));
    }
}
