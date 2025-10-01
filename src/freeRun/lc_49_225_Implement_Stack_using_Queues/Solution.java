package freeRun.lc_49_225_Implement_Stack_using_Queues;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
}

//1,2,3,4,5
//1,2,3,4,5
class MyStack {
    Queue<Integer> queue = new LinkedList<>();

    public MyStack() {

    }

    public void push(int x) {
        Queue<Integer> swapQueue = new LinkedList<>();
        swapQueue.add(x);
        while (!queue.isEmpty()){
            swapQueue.add(queue.remove());
        }
        queue = swapQueue;
    }

    public int pop() {
     return   queue.poll();
    }

    public int top() {
        return  queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
