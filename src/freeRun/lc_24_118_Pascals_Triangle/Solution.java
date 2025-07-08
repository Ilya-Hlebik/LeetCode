package freeRun.lc_24_118_Pascals_Triangle;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(List.of(1));
        while (numRows-- > 1) {
            List<Integer> prev = result.get(result.size() - 1);
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for (int i = 1; i < prev.size(); i++) {
                temp.add(prev.get(i-1) + prev.get(i));
            }
            temp.add(1);
            result.add(temp);
        }
        return result;
    }
}
