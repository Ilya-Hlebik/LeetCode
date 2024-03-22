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
        TreeSet<List<String>> set = new TreeSet<>(Comparator.comparing(o -> String.join("", o)));
        for (Element element : jfk) {
            ArrayList<String> result = new ArrayList<>();
            result.add("JFK");
            HashSet<Element> visited = new HashSet<>();
            dfs(result, element, ways, visited, maxSize, set);
        }
        return set.iterator().next();
    }

    public void dfs(List<String> result, Element element, Map<String, List<Element>> ways, Set<Element> visited, int maxSize, Set<List<String>> bigRes) {
        if (element == null || visited.contains(element)) {
            return;
        }
        result.add(element.key);
        List<Element> elements = ways.get(element.key);
        if (elements == null) {
            if (result.size() == maxSize) {
                bigRes.add(result);
            }
            return;
        }
        visited.add(element);
        for (Element currentEl : elements) {
            if (!bigRes.isEmpty() && bigRes.iterator().next().get(result.size()).compareTo(currentEl.key) < 0) {
                continue;
            }
            ArrayList<String> copyResult = new ArrayList<>(result);
            dfs(copyResult, currentEl, ways, visited, maxSize, bigRes);
            if (copyResult.size() == maxSize) {
                bigRes.add(copyResult);
            }
        }
        visited.remove(element);
    }
    List<String> airports = new ArrayList<>();

    // Add each airport code to the list
    {
        airports.add("JFK");
        airports.add("AXA");
        airports.add("AUA");
        airports.add("ADL");
        airports.add("ANU");
        airports.add("AUA");
        airports.add("ANU");
        airports.add("EZE");
        airports.add("ADL");
        airports.add("EZE");
        airports.add("ANU");
        airports.add("JFK");
        airports.add("AXA");
        airports.add("EZE");
        airports.add("TIA");
        airports.add("AUA");
        airports.add("AXA");
        airports.add("TIA");
        airports.add("ADL");
        airports.add("EZE");

    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> flights = new ArrayList<>();

        // Add each flight as a list of two strings
        flights.add(List.of("AXA", "EZE"));
        flights.add(List.of("EZE", "AUA"));
        flights.add(List.of("ADL", "JFK"));
        flights.add(List.of("ADL", "TIA"));
        flights.add(List.of("AUA", "AXA"));
        flights.add(List.of("EZE", "TIA"));
        flights.add(List.of("EZE", "TIA"));
        flights.add(List.of("AXA", "EZE"));
        flights.add(List.of("EZE", "ADL"));
        flights.add(List.of("ANU", "EZE"));
        flights.add(List.of("TIA", "EZE"));
        flights.add(List.of("JFK", "ADL"));
        flights.add(List.of("AUA", "JFK"));
        flights.add(List.of("JFK", "EZE"));
        flights.add(List.of("EZE", "ANU"));
        flights.add(List.of("ADL", "AUA"));
        flights.add(List.of("ANU", "AXA"));
        flights.add(List.of("AXA", "ADL"));
        flights.add(List.of("AUA", "JFK"));
        flights.add(List.of("EZE", "ADL"));
        flights.add(List.of("ANU", "TIA"));
        flights.add(List.of("AUA", "JFK"));
        flights.add(List.of("TIA", "JFK"));
        flights.add(List.of("EZE", "AUA"));
        flights.add(List.of("AXA", "EZE"));
        flights.add(List.of("AUA", "ANU"));
        flights.add(List.of("ADL", "AXA"));
        flights.add(List.of("EZE", "ADL"));
        flights.add(List.of("AUA", "ANU"));
        flights.add(List.of("AXA", "EZE"));
        flights.add(List.of("TIA", "AUA"));
        flights.add(List.of("AXA", "EZE"));
        flights.add(List.of("AUA", "SYD"));
        flights.add(List.of("ADL", "JFK"));
        flights.add(List.of("EZE", "AUA"));
        flights.add(List.of("ADL", "ANU"));
        flights.add(List.of("AUA", "TIA"));
        flights.add(List.of("ADL", "EZE"));
        flights.add(List.of("TIA", "JFK"));
        flights.add(List.of("AXA", "ANU"));
        flights.add(List.of("JFK", "AXA"));
        flights.add(List.of("JFK", "ADL"));
        flights.add(List.of("ADL", "EZE"));
        flights.add(List.of("AXA", "TIA"));
        flights.add(List.of("JFK", "AUA"));
        flights.add(List.of("ADL", "EZE"));
        flights.add(List.of("JFK", "ADL"));
        flights.add(List.of("ADL", "AXA"));
        flights.add(List.of("TIA", "AUA"));
        flights.add(List.of("AXA", "JFK"));
        flights.add(List.of("ADL", "AUA"));
        flights.add(List.of("TIA", "JFK"));
        flights.add(List.of("JFK", "ADL"));
        flights.add(List.of("JFK", "ADL"));
        flights.add(List.of("ANU", "AXA"));
        flights.add(List.of("TIA", "AXA"));
        flights.add(List.of("EZE", "JFK"));
        flights.add(List.of("EZE", "AXA"));
        flights.add(List.of("ADL", "TIA"));
        flights.add(List.of("JFK", "AUA"));
        flights.add(List.of("TIA", "EZE"));
        flights.add(List.of("EZE", "ADL"));
        flights.add(List.of("JFK", "ANU"));
        flights.add(List.of("TIA", "AUA"));
        flights.add(List.of("EZE", "ADL"));
        flights.add(List.of("ADL", "JFK"));
        flights.add(List.of("ANU", "AXA"));
        flights.add(List.of("AUA", "AXA"));
        flights.add(List.of("ANU", "EZE"));
        flights.add(List.of("ADL", "AXA"));
        flights.add(List.of("ANU", "AXA"));
        flights.add(List.of("TIA", "ADL"));
        flights.add(List.of("JFK", "ADL"));
        flights.add(List.of("JFK", "TIA"));
        flights.add(List.of("AUA", "ADL"));
        flights.add(List.of("AUA", "TIA"));
        flights.add(List.of("TIA", "JFK"));
        flights.add(List.of("EZE", "JFK"));
        flights.add(List.of("AUA", "ADL"));
        flights.add(List.of("ADL", "AUA"));
        flights.add(List.of("EZE", "ANU"));
        flights.add(List.of("ADL", "ANU"));
        flights.add(List.of("AUA", "AXA"));
        flights.add(List.of("AXA", "TIA"));
        flights.add(List.of("AXA", "TIA"));
        flights.add(List.of("ADL", "AXA"));
        flights.add(List.of("EZE", "AXA"));
        flights.add(List.of("AXA", "JFK"));
        flights.add(List.of("JFK", "AUA"));
        flights.add(List.of("ANU", "ADL"));
        flights.add(List.of("AXA", "TIA"));
        flights.add(List.of("ANU", "AUA"));
        flights.add(List.of("JFK", "EZE"));
        flights.add(List.of("AXA", "ADL"));
        flights.add(List.of("TIA", "EZE"));
        flights.add(List.of("JFK", "AXA"));
        flights.add(List.of("AXA", "ADL"));
        flights.add(List.of("EZE", "AUA"));
        flights.add(List.of("AXA", "ANU"));
        flights.add(List.of("ADL", "EZE"));
        flights.add(List.of("AUA", "EZE"));
        System.out.println(solution.findItinerary(flights));
    }
}

class Element {
    public String key;

    public Element(String key) {
        this.key = key;
    }
}
