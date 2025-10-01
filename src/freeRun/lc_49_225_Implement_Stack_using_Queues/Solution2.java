package freeRun.lc_49_225_Implement_Stack_using_Queues;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    class MyStack {
        Queue<Integer> queue = new LinkedList<>();

        public MyStack() {

        }

        public void push(int x) {
            queue.add(x);
            for (int i = 1; i < queue.size(); i++) {
                queue.add(queue.remove());
            }
        }

        public int pop() {
            return queue.poll();
        }

        public int top() {
            return queue.peek();
        }

        public boolean empty() {
            return queue.isEmpty();
        }
    }
}
