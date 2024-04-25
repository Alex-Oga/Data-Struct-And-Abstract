import java.util.*;

public class MyPriorityQueue<T> implements IPriorityQueue<T> {
    private List<T> queueItems;
    private int size;
    private T minimum;
    CompareWith test;
    public MyPriorityQueue(CompareWith<T> cc) {
        queueItems = new ArrayList<>();
        test = cc;
        size = 0;
        minimum = null;
    }

    @Override
    public void add(T item) {
        if (size==0)
            minimum = item;
        if (size>0) {
            if (test.lessThan(item, minimum))
                minimum = item;
        }
        size++;
        queueItems.add(item);
        Collections.sort(queueItems, Collections.reverseOrder());
    }

    @Override
    public void addAll(List<T> items) {
        for (T i: items) {
            if (size==0)
                minimum = i;
            if (size>0) {
                if (test.lessThan(i, minimum))
                    minimum = i;
            }
            queueItems.add(i);
            size++;
        }
        Collections.sort(queueItems, Collections.reverseOrder());
    }

    @Override
    public T getMinimum() {
        return minimum;
    }

    @Override
    public void removeMinimum() {
        queueItems.remove(queueItems.indexOf(minimum));
        size--;
        if (size == 0) {
            minimum = null;
        }
        else {
            minimum = queueItems.get(0);
            for (T i: queueItems) {
                if (test.lessThan(i, minimum))
                    minimum = i;
            }
        }
    }

    @Override
    public int size() {
        return size;
    }
    private class myPriorityQueueRevIterator implements Iterator<T> {
        private int where = 0;

        @Override
        public boolean hasNext() {
            return where < size;
        }

        @Override
        public T next() {
            T tReturn = queueItems.get(where);
            where++;
            return tReturn;
        }
    }
    private class myPriorityQueueIterator implements Iterator<T> {
        private int where = size-1;

        @Override
        public boolean hasNext() {
            return where > -1;
        }

        @Override
        public T next() {
            T tReturn = queueItems.get(where);
            where--;
            return tReturn;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new myPriorityQueueIterator();
    }

    @Override
    public Iterator<T> revIterator() {
        return new myPriorityQueueRevIterator();
    }
}
