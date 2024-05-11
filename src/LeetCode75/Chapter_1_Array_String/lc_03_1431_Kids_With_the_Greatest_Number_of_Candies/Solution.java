package LeetCode75.Chapter_1_Array_String.lc_03_1431_Kids_With_the_Greatest_Number_of_Candies;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        List<Boolean> list = new ArrayList<>();
        for (int candy : candies) {
            max = Math.max(max, candy);
        }
        for (int candy : candies) {
            list.add(candy + extraCandies >= max);
        }
        return list;
    }
}
