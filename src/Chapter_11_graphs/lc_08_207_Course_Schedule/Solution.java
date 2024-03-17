package Chapter_11_graphs.lc_08_207_Course_Schedule;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> toDoMap = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            Set<Integer> orDefault = toDoMap.getOrDefault(prerequisites[i][0], new HashSet<>());
            orDefault.add(prerequisites[i][1]);
            toDoMap.put(prerequisites[i][0], orDefault);
        }
        Set<Integer> solvedDependencies = new HashSet<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int toDo = prerequisites[i][1];
            if (!toDoMap.containsKey(toDo) && !solvedDependencies.contains(toDo)) {
                solvedDependencies.add(toDo);
                i = -1;
            }
        }
        for (int i = 0; i < prerequisites.length && !toDoMap.isEmpty(); i++) {
            if (solvedDependencies.contains(prerequisites[i][1]) && toDoMap.containsKey(prerequisites[i][0])) {
                Set<Integer> set = toDoMap.get(prerequisites[i][0]);
                if (!set.contains(prerequisites[i][1])){
                    continue;
                }
                if (set.size() == 1){
                    solvedDependencies.add(prerequisites[i][0]);
                    toDoMap.remove(prerequisites[i][0]);
                }
                else {
                    set.remove(prerequisites[i][1]);
                }
                i=-1;
            }
        }
        return toDoMap.isEmpty() ;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arr = {
                {0, 0},
                {1, 2},
                {0, 1}
        };
        System.out.println(solution.canFinish(3, arr));
    }
}
