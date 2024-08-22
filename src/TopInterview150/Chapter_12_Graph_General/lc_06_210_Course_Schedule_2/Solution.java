package TopInterview150.Chapter_12_Graph_General.lc_06_210_Course_Schedule_2;

import java.util.*;

public class Solution {
    int index = 0;
    Set<Integer> resolved = new HashSet<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> todo = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            Set<Integer> orDefault = todo.getOrDefault(prerequisite[0], new HashSet<>());
            orDefault.add(prerequisite[1]);
            todo.put(prerequisite[0], orDefault);
        }
        boolean[] visited = new boolean[numCourses];
        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, todo, visited, result)) {
                return new int[]{};
            }
        }
        return result;
    }

    private boolean dfs(int i, Map<Integer, Set<Integer>> todo, boolean[] visited, int[] result) {
        if (resolved.contains(i)){
            return true;
        }
        if (!todo.containsKey(i) || todo.get(i).isEmpty()) {
            result[index++] = i;
            resolved.add(i);
            return true;
        }
        if (visited[i]) {
            return false;
        }
        visited[i] = true;
        Set<Integer> set = todo.get(i);
        for (Integer integer : set) {
            if (!dfs(integer, todo, visited, result)) {
                return false;
            }
        }
        result[index++] = i;
        resolved.add(i);
        set.clear();
        visited[i] = false;
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}})));
    }
}
