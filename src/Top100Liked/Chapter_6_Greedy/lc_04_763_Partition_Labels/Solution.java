package Top100Liked.Chapter_6_Greedy.lc_04_763_Partition_Labels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            map.put(chars[i], i);
        }
        int end = 0;
        int size = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            end = Math.max(end, map.get(chars[i]));
            size++;
            if (end == i) {
                res.add(size);
                size = 0;
            }
        }
        return res;
    }
}
