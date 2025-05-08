package Top100Liked.Chapter_5_Graph.lc_02_207_Course_Schedule;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution2 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return true;
        }
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            Set<Integer> orDefault = map.getOrDefault(prerequisite[0], new HashSet<>());
            orDefault.add(prerequisite[1]);
            map.put(prerequisite[0], orDefault);
        }
        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, map, visited)) {
                return false;
            }
        }
        return true;
    }

    private boolean dfs(int course, Map<Integer, Set<Integer>> map, boolean[] visited) {
        if (visited[course]) {
            return false;
        }
        Set<Integer> preReq = map.get(course);
        if (preReq == null || preReq.isEmpty()) {
            return true;
        }
        visited[course] = true;
        for (Integer i : preReq) {
            if (!dfs(i, map, visited)) {
                return false;
            }
        }
        visited[course] = false;
        preReq.clear();
        return true;
    }

    public static void main(String[] args) {
        int[][] array = {
                {1, 0},
                {2, 1},
                {3, 4},
                {4, 3}
        };
        Solution2 solution = new Solution2();
        System.out.println(solution.canFinish(5, array));
    }
}
