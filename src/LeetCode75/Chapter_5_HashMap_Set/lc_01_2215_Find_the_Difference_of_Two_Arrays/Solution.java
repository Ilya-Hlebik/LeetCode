package LeetCode75.Chapter_5_HashMap_Set.lc_01_2215_Find_the_Difference_of_Two_Arrays;

import java.util.*;

public class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        Set<Integer> answer1 = new HashSet<>();
        Set<Integer> answer2 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            if (!set1.contains(i)){
                answer2.add(i);
            }
            set2.add(i);
        }
        for (int i : nums1) {
            if (!set2.contains(i)){
                answer1.add(i);
            }
        }
        return Arrays.asList(new ArrayList<>(answer1), new ArrayList<>(answer2));
    }
}
