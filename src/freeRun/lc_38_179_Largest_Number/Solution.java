package freeRun.lc_38_179_Largest_Number;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {
    public String largestNumber(int[] nums) {
        String collect = Arrays.stream(nums).boxed().map(Object::toString)
                .sorted((o1, o2) -> {
                    char[] charArray1 = o1.toCharArray();
                    char[] charArray2 = o2.toCharArray();
                    for (int i = 0; i < Math.max(charArray1.length, charArray2.length); i++) {
                        if (i < charArray1.length && i < charArray2.length) {
                            int compare = Integer.compare(Character.digit(charArray2[i], 10), Character.digit(charArray1[i], 10));
                            if (compare != 0) {
                                return compare;
                            }
                        } else if (i < charArray1.length) {
                            for (int j = 0; j < charArray2.length; j++) {
                                int compare = Integer.compare(Character.digit(charArray2[j], 10), Character.digit(charArray1[i], 10));
                                if (compare != 0) {
                                    return compare;
                                }
                            }
                        } else {
                            for (int j = 0; j < charArray1.length; j++) {
                                int compare = Integer.compare(Character.digit(charArray2[i], 10), Character.digit(charArray1[j], 10));
                                if (compare != 0) {
                                    return compare;
                                }
                            }
                        }
                    }
                    return 0;
                })
                .collect(Collectors.joining());
        while (collect.length() > 1 && collect.charAt(0) == '0') {
           collect = collect.substring(1);
        }
        return collect;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largestNumber(new int[]{92, 923}));
    }
}
