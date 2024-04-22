package Chapter_4_stack.lc_06_853_Car_Fleet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Solution3 {
    public int carFleet(int target, int[] position, int[] speed) {
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>();
        for (int i = 0; i < position.length; i++) {
            list.add(Map.entry(position[i], speed[i]));
        }
        list.sort((o1, o2) -> o2.getKey().compareTo(o1.getKey()));
        Stack<Double> stack = new Stack<>();
        for (Map.Entry<Integer, Integer> entry : list) {
            double newElementTime = (double) (target - entry.getKey()) / entry.getValue();
            if (!stack.isEmpty()) {
                if (newElementTime > stack.peek()) {
                    stack.push(newElementTime);
                }
            } else {
                stack.push(newElementTime);
            }
        }
        return stack.size();
    }

    public static void main(String[] args) {
        Solution3 solution = new Solution3();
        System.out.println(solution.carFleet(12, new int[]{10, 8, 0, 5, 3}, new int[]{2, 4, 1, 1, 3}));
        System.out.println(solution.carFleet(10, new int[]{3}, new int[]{3}));
        System.out.println(solution.carFleet(100, new int[]{0, 2, 4}, new int[]{4, 2, 1}));
        System.out.println(solution.carFleet(10, new int[]{8, 3, 7, 4, 6, 5}, new int[]{4, 4, 4, 4, 4, 4}));
    }
}
