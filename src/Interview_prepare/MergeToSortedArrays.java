package Interview_prepare;

import java.util.ArrayList;
import java.util.List;

public class MergeToSortedArrays {

    public static void main(String[] args) {
        MergeToSortedArrays mergeToSortedArrays = new MergeToSortedArrays();

        List<Integer> l1 = new ArrayList<>();
        l1.add(4);
        l1.add(5);
        l1.add(7);
        l1.add(9);
        List<Integer> l2 = new ArrayList<>();
        l2.add(1);
        l2.add(2);
        l2.add(6);
        l2.add(9);
        merge(l1,l2);
        System.out.println(l1);
    }

    public static void merge(List<Integer> l1, List<Integer> l2) {
        for (int index1 = 0, index2 = 0; index2 < l2.size(); index1++) {
            if (index1 == l1.size() || l1.get(index1) > l2.get(index2)) {
                l1.add(index1, l2.get(index2++));
            }
        }
    }
}
