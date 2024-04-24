package Interview_prepare.newrub;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution2 {
    public static void main(String[] args) {
        Solution2 solution2 = new Solution2();
        System.out.println(Arrays.toString(solution2.frequencySort(new int[]{2, 3, 1, 3, 2})));
    }

    public int[] frequencySort(int[] nums) {
        int res[] = new int[nums.length];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> collect = map.entrySet().stream().sorted((o1, o2) -> {
            int compare = Integer.compare(o1.getValue(), o2.getValue());
            if (compare == 0) {
                return Integer.compare(o2.getKey(), o1.getKey());
            }
            return compare;
        }).collect(Collectors.toList());
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : collect) {
            for (int i = 0; i < entry.getValue(); i++) {
                res[index++] = entry.getKey();
            }
        }
        return res;
    }
}
