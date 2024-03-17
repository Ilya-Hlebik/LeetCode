package Chapter_11_graphs.lc_08_207_Course_Schedule;

import java.util.*;

public class Solution2 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> toDoMap = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            Set<Integer> orDefault = toDoMap.getOrDefault(prerequisites[i][0], new HashSet<>());
            orDefault.add(prerequisites[i][1]);
            toDoMap.put(prerequisites[i][0], orDefault);
        }
        boolean needContinue = true;
        while (needContinue) {
            Integer tobeRemoved = null;
            needContinue = false;
            for (Map.Entry<Integer, Set<Integer>> entry : toDoMap.entrySet()) {
                Set<Integer> value = entry.getValue();
                Iterator<Integer> iterator = value.iterator();
                while (iterator.hasNext()){
                    Integer next = iterator.next();
                    if (!toDoMap.containsKey(next)){
                        value.remove(next);
                    }
                }
                if (value.isEmpty()){
                    tobeRemoved = entry.getKey();
                    needContinue = true;
                    break;
                }
            }
            if (tobeRemoved != null){
                toDoMap.remove(tobeRemoved);
            }
        }
        return toDoMap.isEmpty();
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
        System.out.println(solution.canFinish(5, arr));
    }
}
