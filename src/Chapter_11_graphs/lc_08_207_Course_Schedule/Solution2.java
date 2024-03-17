package Chapter_11_graphs.lc_08_207_Course_Schedule;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution2 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> toDoMap = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            toDoMap.put(i, new HashSet<>());
        }
        for (int[] prerequisite : prerequisites) {
            Set<Integer> orDefault = toDoMap.getOrDefault(prerequisite[0], new HashSet<>());
            orDefault.add(prerequisite[1]);
            toDoMap.put(prerequisite[0], orDefault);
        }
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < numCourses; i++) {
           if (!dfs(i, visited, toDoMap)){
               return false;
           }
        }
        return true;
    }
    public boolean dfs(int crs, Set<Integer> visited,   Map<Integer, Set<Integer>> toDoMap){
        if (visited.contains(crs)){
            return false;
        }
        if (toDoMap.get(crs).isEmpty()){
            return true;
        }
        visited.add(crs);
        for (Integer integer : toDoMap.get(crs)) {
            if (!dfs(integer,visited, toDoMap)){
                return false;
            }
        }
        visited.remove(crs);
        toDoMap.put(crs, new HashSet<>());
        return true;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[][] arr = {
                {0, 1},
                {0, 2},
                {1, 3},
                {1, 4},
                {3, 4}
        };
        //4, 3 1, 0, 2
        System.out.println(solution.canFinish(5, arr));
    }
}
