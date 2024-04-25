class IntArrayList {
    private int[] items;
    int size;

    public IntArrayList() {
        items = new int[6];
        size = 0;
    }

    public int getFirst() {
        return items[0];
    }

    public int getLast() {
        return items[size - 1];
    }

    public int get(int index) {
        return items[index];
    }

    public int size() {
        return size;
    }

    private void grow(int newCap) {
        int[] expandedItems = new int[newCap];
        System.arraycopy(items, 0, expandedItems, 0, size);
        items = expandedItems;
    }

    public void addLast(int val) {
        if (size == items.length) {
            grow(2 * size);
        }
        items[size] = val;
        size++;
    }

    public void removeLast() {
        size--;
        items[size] = 0;
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < size; i++) {
            str += items[i] + ", ";
        }
        return str;
    }

    public void addFirst(int x) {
        if (size == items.length) {
            grow(2*size);
        }
        size++;
        System.arraycopy(items, 0, items, 1, size);
        items[0] = x;
        /*
        It changes with the length of the list, if the list is not connected circularly
        It takes time proportional to the length of the list
         */
    }
}

public class AList<T> {
    T[] items;
    int size;

    public AList() {
        items = (T[]) new Object[10];
        size = 0;
    }
    public AList(int n) {
        items = (T[]) new Object[n];
        size = 0;
    }

    public T getFirst() { return items[0]; }
    public T getLast() { return items[size-1]; }
    public T get(int index) { return items[index]; }
    public void grow(int x) {
        T[] expandedItems = (T[]) new Object[x];
        System.arraycopy(items, 0, expandedItems, 0, size);
        items = expandedItems;
    }
    public void addLast(T x) {
        if (size == items.length) { grow(2*size); }
        items[size] = x;
        size++;
    }
    public void addFirst(T x) {
        if (size == items.length) { grow(2*size); }
        System.arraycopy(items, 0, items, 1, size);
        items[0] = x;
        size++;
    }
    public void insert(T x, int index) { items[index] = x; }
    public int size() { return size; }
    public String toString() {
        String str = "";
        for (int i=0; i<size; i++) { str += items[i] + ", "; }
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
}