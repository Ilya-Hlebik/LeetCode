package Chapter_11_graphs.lc_09_207_Course_Schedule;

import java.util.*;

public class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new HashSet<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            map.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }
        Set<Integer> order = new LinkedHashSet<>();
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, map, visited, order)) {
                return new int[]{};
            }
        }
        int[] result = new int[order.size()];
        int i = 0;
        for (Integer integer : order) {
            result[i++] = integer;
        }
        return result;
    }

    private boolean dfs(int cur, Map<Integer, Set<Integer>> map, Set<Integer> visited, Set<Integer> order) {
        if (visited.contains(cur)) {
            return false;
        }
        if (map.get(cur).isEmpty()) {
            order.add(cur);
            return true;
        }
        visited.add(cur);
        for (Integer integer : map.get(cur)) {
            if (!dfs(integer, map, visited, order)) {
                return false;
            }
        }
        order.add(cur);
        visited.remove(cur);
        map.put(cur, new HashSet<>());
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {
                {0, 1},
                {0, 2},
                {1, 3},
                {1, 4},
                {3, 4}
        };
        System.out.println(Arrays.toString(solution.findOrder(5, arr)));
    }
}
