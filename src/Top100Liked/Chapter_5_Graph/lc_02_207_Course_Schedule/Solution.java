package Top100Liked.Chapter_5_Graph.lc_02_207_Course_Schedule;

import java.util.*;

public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return true;
        }
        Set<Integer> finished = new HashSet<>();
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] prerequisite : prerequisites) {
            Set<Integer> orDefault = map.getOrDefault(prerequisite[0], new HashSet<>());
            orDefault.add(prerequisite[1]);
            map.put(prerequisite[0], orDefault);
        }
        Stack<Integer> stack = new Stack<>();
        Set<Integer> visited = new HashSet<>();
        int number = 0;
        stack.add(number);
        while (!stack.isEmpty()) {
            Integer peek = stack.peek();
            Set<Integer> fromMap = map.get(peek);
            if (finished.contains(peek) || fromMap == null || finished.containsAll(fromMap)) {
                finished.add(peek);
                stack.pop();
            }
            else if (visited.contains(peek)){
                return false;
            }
            else {
                visited.add(peek);
                stack.addAll(fromMap);
            }
            if (stack.isEmpty() && ++number<numCourses){
                stack.add(number);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] array = {
                {1, 0},
                {2, 1},
                {3, 4},
                {4, 3}
        };
        Solution solution = new Solution();
        System.out.println(solution.canFinish(5, array));
    }
}
