package Chapter_12_advanced_graphs.lc_06_787_Cheapest_Flights_Within_K_Stops;

import java.util.Arrays;

public class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        float prices[] = new float[n];
        for (int i = 0; i < prices.length; i++) {
            prices[i] = Float.POSITIVE_INFINITY;
        }
        prices[src] = 0;
        for (int i = 0; i < k + 1; i++) {
            float[] tempPrices = Arrays.copyOf(prices, prices.length);
            for (int[] flight : flights) {
                int source = flight[0];
                int destination = flight[1];
                int price = flight[2];
                if (Float.isInfinite(prices[source])) {
                    continue;
                }
                if (prices[source] + price < tempPrices[destination]) {
                    tempPrices[destination] = prices[source] + price;
                }
            }
            prices = tempPrices;
        }
        return Float.isInfinite(prices[dst]) ? -1 : (int) prices[dst];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] list = {
                {0, 1, 100},
                {1, 2, 100},
                {2, 0, 100},
                {1, 3, 600},
                {2, 3, 200}
        };
        System.out.println(solution.findCheapestPrice(4, list, 0, 3, 1));
/*
        int[][] list2 = {
                {0, 1, 100},
                {1, 2, 100},
                {0, 2, 500}
        };
        System.out.println(solution.findCheapestPrice(3, list2, 0, 2, 1));

        int[][] list3 = {
                {0, 1, 100},
                {1, 2, 100},
                {0, 2, 500}
        };
        System.out.println(solution.findCheapestPrice(3, list3, 0, 2, 0));

        int[][] list4 = {
                {4, 1, 1},
                {1, 2, 3},
                {0, 3, 2},
                {0, 4, 10},
                {3, 1, 1},
                {1, 4, 3}
        };

        System.out.println(solution.findCheapestPrice(5, list4, 2, 1, 1));

 */
    }
}
