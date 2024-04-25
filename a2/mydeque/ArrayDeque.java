public class ArrayDeque<T> {
    T[] items;
    int size = 0;

    public ArrayDeque() { items = (T[]) new Object[8]; }
    public ArrayDeque(ArrayDeque<T> other) {
        items = (T[]) new Object[other.items.length];
        System.arraycopy(other.items, 0, items, 0, other.items.length);
    }

    public void addFirst(T item) {
        if (size == items.length)
            grow(2*size);
        System.arraycopy(items, 0, items, 1, size);
        items[0] = item;
        size++;
    }
    public void addLast(T item) {
        if (size == items.length)
            grow(2*size);
        items[size] = item;
        size++;
    }
    public boolean isEmpty() {
        if (size == 0)
            return true;
        return false;
    }
    public int size() {
        return size;
    }
    public String toString() {
        String str = "";
        for (int i=0; i<size; i++) {
            str += items[i] +" ";
        }
        return str;
    }
    public T removeFirst() {
        size--;
        T returnItem = items[0];
        if (items[0] != null) {
            System.arraycopy(items, 1, items, 0, size);
            return returnItem;
        }
        else
            return null;
    }
    public T removeLast() {
        size--;
        T returnItems = items[size];
        if (items[size] != null) {
            items[size] = null;
            return returnItems;
        }
        else
            return null;
    }
    public T get(int index) {
        int counter = 0;
        for (int i=0; i<items.length; i++) {
            if (counter == index) {
                return items[index];
            }
        }
        return null;
    }
    public void printDeque() {
        System.out.println(items.length);
    }
    public void grow(int newCap) {
        T[] expandedItems = (T[]) new Object[newCap];
        System.arraycopy(items, 0, expandedItems, 0, size);
        items = expandedItems;
    }
}
