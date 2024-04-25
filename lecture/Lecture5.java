class IntArrayList {
    private int[] items; // capacity: items.length
    int size;

    public IntArrayList() {
        items = new int[6];
        size = 0;
    }

    public int getFirst() { return items[0]; }
    public int getLast() { return items[size-1]; }
    public int get(int index) {return items[index]; }
    public int size() { return size; }
    private void grow(int newCap) {
        int[] expandedItems = new int[newCap];
        System.arraycopy(items, 0, expandedItems, 0, size);
        items = expandedItems;
    }
    public void addLast(int val) {
        if (size == items.length) { // It's full
            // grow(size+1); // Option 1
            grow(2*size); // Option 2
        }
        items[size] = val;
        size++;
        // items[size++] = val;
    }
    public void removeLast() {
        size--;
        items[size] = 0; // null? not a reference type, can't use null
    }
    public String toString() {
        String str = "";
        for (int i=0; i<size; i++) {
            str += items[i]+"";
        }
        return str;
    }
}

public class Lecture5 {
    public static void main(String[] args) {
        IntArrayList arr = new IntArrayList();

        long start = System.nanoTime();
        for (int i=0; i<2_000_000; i++) {
            arr.addLast(i+1);
        }
        long end = System.nanoTime();
        System.out.printf("Took %f ms\n", (end - start)/1e6);
        System.out.println(arr.getLast());


    }
}
