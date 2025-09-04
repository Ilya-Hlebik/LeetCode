package freeRun.lc_38_179_Largest_Number;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {
    public String largestNumber(int[] nums) {
        String result = Arrays.stream(nums).boxed().map(Object::toString)
                .sorted((o1, o2) -> (o2 + o1).compareTo(o1 + o2))
                .collect(Collectors.joining());
        return result.charAt(0) =='0'? "0": result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largestNumber(new int[]{12341, 123411234}));
    }
}
