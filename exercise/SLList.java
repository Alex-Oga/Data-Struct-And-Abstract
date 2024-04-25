public class SLList {
    class IntNode {
        int head;
        IntNode next;

        public IntNode(int head, IntNode next) {
            this.head = head;
            this.next = next;
        }
    }
    private IntNode sen;
    private int size;

    public SLList() {
        size = 0;
        sen = new IntNode(-1, null);
    }
    public SLList(int x) {
        size = 1;
        sen = new IntNode(-1, new IntNode(x, null));
    }
    public void addFirst(int x) {
        size++;
        sen = new IntNode(-1, new IntNode(x, sen.next));
    }
    public void addLast(int x) {
        size++;
        IntNode p = sen;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
    }
    public int getFirst() {
        return sen.next.head;
    }
    public int getLast() {
        IntNode p = sen;
        while (p.next != null) {
            p = p.next;
        }
        return p.head;
    }
    public int size() { return size; }
    public String toString() {
        String str = "";
        IntNode p = sen.next;
        while (p != null) {
            str += p.head+", ";
            p = p.next;
        }
        return str;
    }
    public void removeFirst() {
        if (size > 0) {
            sen.next = sen.next.next;
        }
    }
    public void insert(int newValue, int k) {
        int cycle = 0;
        IntNode p = sen;

        while (cycle != k) {
            p = p.next;
            cycle++;
        }
        p.next = new IntNode(newValue, p.next);
    }
}
