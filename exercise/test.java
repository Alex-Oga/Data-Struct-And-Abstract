public class test {
    int[] items;
    int size;

    public test() {
        items = new int[2];
        size = 0;
    }

    public void grow(int newCapacity) {
        int[] newItems = new int[newCapacity];
        System.arraycopy(items, 0, newItems, 0, size);
        items = newItems;
    }

    public void add(int value) {
        if (size == items.length) {
            grow(items.length*2);
        }
        items[size] = value;
        size += 1;
    }

    public void insert(int pos, int val) {
        if (size == items.length) {
            grow(size*2);
        }
        if (size < pos || 0 > pos) {
            throw new IndexOutOfBoundsException();
        }

        int[] newItems = new int[items.length];
        int count = 0;

        for(int i=0; i<=size; i++) {
            if (i == pos) {
                newItems[i] = val;
                i++;
            }
            newItems[i] = items[count];
            count++;
        }

        size++;
        items = newItems;

    }

    public boolean equals(Object other) {
        if (other==null || this.getClass()!=other.getClass()) { return false; }
        if (this == other) { return true; }

        test o = (test) other;

        if (this.size != o.size) {
            return false;
        }

        for (int i=0; i<this.size; i++) {
            if (this.items[i] != o.items[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        test a = new test();
        a.add(1);
        a.add(2);
        a.insert(0, 3);
        a.insert(0, 4);
        for (int i: a.items) {
            System.out.println(i);
        }
        test b = new test();
        b.add(1);
        b.add(3);
        System.out.println(a.equals(b));
    }

}
