import java.util.Iterator;
import java.util.Objects;
import java.util.function.Consumer;

public class iterableAList<T> implements Iterable<T> {
    T[] items;
    int size;

    public iterableAList() {
        items = (T[]) new Object[10];
        size = 0;
    }

    public iterableAList(int n) {
        items = (T[]) new Object[n];
        size = 0;
    }

    public T getFirst() {
        return items[0];
    }

    public T getLast() {
        return items[size - 1];
    }

    public T get(int index) {
        return items[index];
    }

    public void grow(int x) {
        T[] expandedItems = (T[]) new Object[x];
        System.arraycopy(items, 0, expandedItems, 0, size);
        items = expandedItems;
    }

    public void addLast(T x) {
        if (size == items.length) {
            grow(2 * size);
        }
        items[size] = x;
        size++;
    }

    public void addFirst(T x) {
        if (size == items.length) {
            grow(2 * size);
        }
        System.arraycopy(items, 0, items, 1, size);
        items[0] = x;
        size++;
    }

    public void insert(T x, int index) {
        items[index] = x;
    }

    public int size() {
        return size;
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < size; i++) {
            str += items[i] + ", ";
        }
        return str;
    }

    public T removeFirst() {
        T itemToRemove = items[0];
        size--;
        System.arraycopy(items, 1, items, 0, size);
        return itemToRemove;
    }

    public T removeLast() {
        T itemToRemove = items[size - 1];
        items[size - 1] = null;
        size--;

        return itemToRemove;
    }

    @Override
    public Iterator<T> iterator() {
        return new iterableAListIterator();
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Objects.requireNonNull(action);
        for (T t : this) {
            action.accept(t);
        }
    }

    private class iterableAListIterator implements Iterator<T> {
        private int where;

        public iterableAListIterator() {
            where = 0;
        }

        @Override
        public boolean hasNext() {
            return where < size;
        }

        @Override
        public T next() {
            T tReturn = get(where);
            where++;
            return tReturn;
        }
    }
}
