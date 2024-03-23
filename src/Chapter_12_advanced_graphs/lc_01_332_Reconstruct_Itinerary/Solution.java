package Chapter_12_advanced_graphs.lc_01_332_Reconstruct_Itinerary;

import java.util.*;

public class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        LinkedList<String> itinerary = new LinkedList<>();
        Map<String, PriorityQueue<String>> graph = new HashMap<>();
        Stack<String> stack = new Stack<>();
        for (List<String> ticket : tickets) {
            PriorityQueue<String> orDefault = graph.getOrDefault(ticket.get(0), new PriorityQueue<>());
            orDefault.add(ticket.get(1));
            graph.put(ticket.get(0), orDefault);
        }
        stack.push("JFK");
        while (!stack.isEmpty()) {
            String nextDestination = stack.peek();
            if (graph.get(nextDestination) != null && !graph.get(nextDestination).isEmpty()) {
                stack.push(graph.get(nextDestination).poll());
            } else {
                itinerary.addFirst(stack.pop());
            }
        }
        return itinerary;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> flights = new ArrayList<>();
        //JFK SFO JFK ATL SFO ATL
        // Add each flight as a list of two strings
        flights.add(List.of("JFK", "SFO"));
        flights.add(List.of("JFK", "ATL"));
        flights.add(List.of("PRS", "QWE"));
        flights.add(List.of("SFO", "JFK"));
        flights.add(List.of("ATL", "PRS"));
        System.out.println(solution.findItinerary(flights));
    }
}
