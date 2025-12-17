package freeRun.lc_67_284_Peeking_Iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class Solution {
    public static void main(String[] args) {
        ArrayList<Integer> objects = new ArrayList<>();
        objects.add(1);
        objects.add(2);
        objects.add(3);
        PeekingIterator peekingIterator = new PeekingIterator(objects.iterator());
        System.out.println(peekingIterator.hasNext());
        System.out.println(peekingIterator.next());
        System.out.println(peekingIterator.peek());
    }
}

class PeekingIterator<T> implements Iterator<T> {
    Iterator<T> iterator;
    T peeked = null;

    public PeekingIterator(Iterator<T> iterator) {
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public T peek() {
        if (peeked == null) {
            peeked = iterator.next();
        }
        return peeked;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public T next() {
        if (peeked != null) {
            T temp = peeked;
            peeked = null;
            return temp;
        }
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext() || peeked != null;
    }
}
