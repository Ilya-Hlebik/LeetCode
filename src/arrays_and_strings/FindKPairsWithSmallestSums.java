package arrays_and_strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FindKPairsWithSmallestSums {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> que = new PriorityQueue<>((a,b)->a.get(0)+a.get(1)-b.get(0)-b.get(1));
        List<List<Integer>> res = new ArrayList<>();
        if(nums1.length==0 || nums2.length==0 || k==0) return res;
        for(int i=0; i<nums1.length && i<k; i++) {
            que.offer(Arrays.asList(nums1[i], nums2[0], 0));
        }
        while(k-- > 0 && !que.isEmpty()){
            List<Integer> cur = que.poll();
            res.add(Arrays.asList(cur.get(0), cur.get(1)));
            if(cur.get(2) == nums2.length-1) {
                continue;
            }
            que.offer(Arrays.asList(cur.get(0),nums2[cur.get(2)+1], cur.get(2)+1));
        }
        return res;
      /*
        for (int i = 0; i < nums1.length; i++) {
            for (int i1 = 0; i1 < nums2.length; i1++) {
                result.add(Arrays.asList(nums1[i], nums2[i1]));
            }
        }

        return result.stream()
                .sorted(Comparator.comparingInt(o -> (o.get(0) + o.get(1))))
                .limit(k).collect(Collectors.toList());
                        return result;
                */
    }

    public static void main(String[] args) {
        FindKPairsWithSmallestSums findKPairsWithSmallestSums = new FindKPairsWithSmallestSums();
        System.out.println(findKPairsWithSmallestSums.kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3));
        System.out.println(findKPairsWithSmallestSums.kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 2));
        System.out.println(findKPairsWithSmallestSums.kSmallestPairs(new int[]{1, 2}, new int[]{3}, 3));
    }
}
