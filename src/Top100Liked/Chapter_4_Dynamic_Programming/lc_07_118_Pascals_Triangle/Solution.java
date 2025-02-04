package Top100Liked.Chapter_4_Dynamic_Programming.lc_07_118_Pascals_Triangle;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        int lineSize = 1;
        while (numRows > 0) {
            List<Integer> line = new ArrayList<>();
            line.add(1);
            if (lineSize > 2) {
                List<Integer> lastLine = result.get(result.size() - 1);
                Integer prevItem = null;
                for (int i = 0; i < lastLine.size(); i++) {
                    Integer currentItem = lastLine.get(i);
                    if (prevItem == null) {
                        prevItem = currentItem;
                        continue;
                    }
                    line.add(prevItem + currentItem);
                    prevItem = currentItem;
                }
            }
            if (lineSize > 1) {
                line.add(1);
            }
            lineSize++;
            numRows--;
            result.add(line);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generate(2));
    }
}
