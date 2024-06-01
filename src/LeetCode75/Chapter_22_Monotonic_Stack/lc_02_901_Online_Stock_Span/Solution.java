package LeetCode75.Chapter_22_Monotonic_Stack.lc_02_901_Online_Stock_Span;

import java.util.Map;
import java.util.Stack;

public class Solution {
}

class StockSpanner {
    Stack<Map.Entry<Integer, Integer>> priceSpan = new Stack<>();

    public StockSpanner() {

    }

    public int next(int price) {
        if (priceSpan.isEmpty()) {
            priceSpan.add(Map.entry(price, 1));
        } else {
            int temp = 1;
            while (!priceSpan.isEmpty() && priceSpan.peek().getKey() <= price) {
                temp += priceSpan.pop().getValue();
            }
            priceSpan.add(Map.entry(price, temp));
        }
        return priceSpan.peek().getValue();
    }
}
