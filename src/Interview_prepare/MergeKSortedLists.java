package Interview_prepare;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public List<Integer> mergeKLists(List<List<Integer>> arrays) {
        PriorityQueue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(o -> o.integers.get(o.index)));
        for (List<Integer> array : arrays) {
            if (!array.isEmpty()) {
                minHeap.add(new Node(0, array));
            }
        }
        List<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            Node poll = minHeap.poll();
            int index = poll.index;
            Integer value = poll.integers.get(index);
            if (result.isEmpty() || !result.get(result.size() - 1).equals(value)) {
                result.add(value);
            }
            if (index + 1 < poll.integers.size()) {
                poll.index = index + 1;
                minHeap.add(poll);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MergeKSortedLists mergeKSortedLists = new MergeKSortedLists();
        List<Integer> list1 = List.of(1, 2, 3, 4, 6);
        List<Integer> list2 = List.of();
        List<Integer> list3 = List.of(3, 4, 7);
        System.out.println(mergeKSortedLists.mergeKLists(List.of(list1, list2, list3)));
    }
}

class Node {
    int index;
    List<Integer> integers;

    public Node(int index, List<Integer> integers) {
        this.index = index;
        this.integers = integers;
    }
}
