package Chapter_12_advanced_graphs.lc_01_332_Reconstruct_Itinerary;

import java.util.*;

public class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<Element>> ways = new HashMap<>();
        for (List<String> ticket : tickets) {
            List<Element> orDefault = ways.getOrDefault(ticket.get(0), new ArrayList<>());
            orDefault.add(new Element(ticket.get(1)));
            ways.put(ticket.get(0), orDefault);
        }
        int maxSize = tickets.size() + 1;
        List<Element> jfk = ways.get("JFK");
        TreeSet<List<String >> set = new TreeSet<>(Comparator.comparing(o -> String.join("", o)));
        for (Element element : jfk) {
            ArrayList<String> result = new ArrayList<>();
            result.add("JFK");
            HashSet<Element> visited = new HashSet<>();

            dfs(result, element, ways, visited, maxSize);
            if (result.size() == maxSize){
                set.add(result);
            }
        }
        return set.iterator().next();
    }

    public void dfs(List<String> result, Element element, Map<String, List<Element>> ways, Set<Element> visited, int maxSize) {
        if (element == null || visited.contains(element)) {
            return;
        }
        visited.add(element);
        result.add(element.key);
        List<Element> elements = ways.get(element.key);
        if (result.size()< maxSize && elements == null) {
            result.remove(element.key);
            visited.remove(element);
            return;
        }
        else if (elements == null){
            return;
        }
        for (Element currentEl : elements) {
            dfs(result, currentEl, ways, visited, maxSize);
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> flights = new ArrayList<>();

        // Add each flight as a list of two strings
        flights.add(List.of("EZE", "AXA"));
        flights.add(List.of("TIA", "ANU"));
        flights.add(List.of("ANU", "JFK"));
        flights.add(List.of("JFK", "ANU"));
        flights.add(List.of("ANU", "EZE"));
        flights.add(List.of("TIA", "ANU"));
        flights.add(List.of("AXA", "TIA"));
        flights.add(List.of("TIA", "JFK"));
        flights.add(List.of("ANU", "TIA"));
        flights.add(List.of("JFK", "TIA"));
        System.out.println(solution.findItinerary(flights));
    }
}

class Element {
    public String key;

    public Element(String key) {
        this.key = key;
    }
}
