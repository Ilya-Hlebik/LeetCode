package Chapter_15_Greedy.lc_05_846_Hand_of_Straights;

import java.util.*;

public class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        Arrays.sort(hand);
        Set<Integer> usedIndexes = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        int count = 0;
        int targetSum = hand.length / groupSize;
        for (int i = 0; i < hand.length; i++) {
            if (!usedIndexes.contains(i) && (list.isEmpty() || list.get(list.size() - 1) - hand[i] == -1)) {
                usedIndexes.add(i);
                list.add(hand[i]);
                if (list.size() == groupSize) {
                    list.clear();
                    count++;
                    if (count == targetSum){
                        return true;
                    }
                    i = -1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isNStraightHand(new int[]{1,2,3,4,5,6}, 2));
    }
}
