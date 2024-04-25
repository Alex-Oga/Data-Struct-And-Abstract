import java.util.NoSuchElementException;

public class MyArrayList {

    private int[] items;
    private int size;
    public MyArrayList() {
        items = new int[2];
        size = 0;
    }

    private void grow(int newCapacity) {
        int[] newItems = new int[newCapacity];
        System.arraycopy(items, 0, newItems, 0, size);
        items = newItems;
    }

    public void add(int value) {
        if (size == items.length) {
            grow(size*2);
        }
        items[size] = value;
        size++;
    }

    public int size() {
        return size;
    }

    public int removeFirst() {
        if (size <= 0) {
            throw new NoSuchElementException();
        }
        size--;
        int returnValue = items[0];
        System.arraycopy(items, 1, items, 0, size);
        return returnValue;
    }

    public boolean equals(Object o) {
        if (o == null || this.getClass() != o.getClass())
            return false;
        if (o == this)
            return true;
        MyArrayList other = (MyArrayList) o;
        if (this.size() != other.size())
            return false;
        for (int i=0; i<this.size(); i++) {
            if (this.items[i] != other.items[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        MyArrayList a = new MyArrayList();
        a.add(1);
        a.add(2);
        a.removeFirst();
        a.removeFirst();
        a.add(3);
        System.out.println(a.removeFirst());
    }

}
