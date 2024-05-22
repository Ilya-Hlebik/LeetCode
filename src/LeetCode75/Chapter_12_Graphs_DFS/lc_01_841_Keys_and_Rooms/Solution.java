package LeetCode75.Chapter_12_Graphs_DFS.lc_01_841_Keys_and_Rooms;

import java.util.*;

public class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> toBeVisit = new LinkedList<>();
        visited.add(0);
        toBeVisit.addAll(rooms.get(0));
        while (!toBeVisit.isEmpty() && visited.size() != rooms.size()) {
            Integer poll = toBeVisit.poll();
            if (visited.contains(poll)) {
                continue;
            }
            visited.add(poll);
            toBeVisit.addAll(rooms.get(poll));
        }
        return visited.size() == rooms.size();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(List.of(1));
        rooms.add(List.of(2));
        rooms.add(List.of(3));
        rooms.add(List.of());
        solution.canVisitAllRooms(rooms);
    }
}
