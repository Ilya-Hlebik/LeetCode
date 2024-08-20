package TopInterview150.Chapter_12_Graph_General.lc_04_399_Evaluate_Division;

import java.util.*;

public class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] answer = new double[queries.size()];
        Map<String, List<Edge>> map = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            List<String> equation = equations.get(0);
            addEdge(map, equation.get(0), equation.get(1), values[i]);
            addEdge(map, equation.get(1), equation.get(0), 1 / values[i]);
        }
        for (int i = 0; i < answer.length; i++) {
            List<String> query = queries.get(i);
            answer[i] = dfs(map, new HashSet<>(), query.get(0), query.get(1));
        }
        return answer;
    }

    private double dfs(Map<String, List<Edge>> map, Set<String> set, String u, String v) {
        if (!map.containsKey(u) || !map.containsKey(v)) {
            return -1;
        }
        if (u.equals(v)) {
            return 1;
        }
        List<Edge> edges = map.get(u);
        for (Edge edge : edges) {
            if (set.contains(edge.v)) {
                continue;
            } else if (edge.v.equals(v)) {
                return edge.value;
            }
            set.add(u);
            double val = dfs(map, set, edge.v, v);
            if (val != -1) {
                return val * edge.value;
            }
        }
        return -1;
    }

    private void addEdge(Map<String, List<Edge>> map, String u, String v, double value) {
        if (!map.containsKey(u)) {
            map.put(u, new ArrayList<>());
        }
        map.get(u).add(new Edge(v, value));
    }
}

class Edge {
    String v;
    double value;

    public Edge(String v, double value) {
        this.v = v;
        this.value = value;
    }
}
