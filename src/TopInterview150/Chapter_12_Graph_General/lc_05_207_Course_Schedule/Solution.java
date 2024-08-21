package TopInterview150.Chapter_12_Graph_General.lc_05_207_Course_Schedule;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> todo = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            Set<Integer> orDefault = todo.getOrDefault(prerequisite[0], new HashSet<>());
            orDefault.add(prerequisite[1]);
            todo.put(prerequisite[0], orDefault);
        }
        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, todo, visited)){
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int i, Map<Integer, Set<Integer>> todo, boolean[] visited) {
        if (!todo.containsKey(i) || todo.get(i).isEmpty()){
            return true;
        }
        if (visited[i]){
            return false;
        }
        visited[i] = true;
        Set<Integer> set = todo.get(i);
        for (Integer integer : set) {
            if (!dfs(integer, todo, visited)) {
                return false;
            }
        }
        set.clear();
        visited[i] = false;
        return true;
    }
}
