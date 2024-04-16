package Chapter_15_Greedy.lc_05_846_Hand_of_Straights;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false;
        Map<Integer, Integer> items = new HashMap<>();
        for (int i : hand) {
            items.put(i, items.getOrDefault(i, 0) + 1);
        }
        Arrays.sort(hand);

        for (int card : hand) {
            if (items.get(card) <= 0) {
                continue;
            }
            for (int i = 1; i < groupSize; i++) {
                int count = items.getOrDefault(card + i, 0);
                if (count <= 0) {
                    return false;
                }
                items.put(card + i, count - 1);
            }
            items.put(card, items.get(card) - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.isNStraightHand(new int[]{1, 2, 3, 4, 5, 6}, 2));
    }
}
