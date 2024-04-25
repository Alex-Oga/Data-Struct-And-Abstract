public class IntNode {
    int head;
    IntNode next;

    public IntNode(int head, IntNode next) {
        this.head = head;
        this.next = next;
    }

    public String iterativeToString() {
        IntNode current = this;
        String list = "";

        while (current != null) {
            list += current.head  + ", ";
            current = current.next;
        }
        return list;
    }
    public int get(int i) {
        IntNode current = this;
        int count = 0;

        while (count != i) {
            current = current.next;
            count++;
        }
        return current.head;
    }
    public void set(int i, int newValue) {
        IntNode current = this;
        int count = 0;

        while (count != i) {
            current = current.next;
            count++;
        }
        current.head = newValue;
    }
    public IntNode incrList(int delta) {
        if (this.next == null)
            return new IntNode(this.head + delta, null);
        else
            return new IntNode(this.head + delta, this.next.incrList(delta));
    }
}
