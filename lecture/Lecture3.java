
class IntNode { // not public
    int head;
    IntNode next;
    public IntNode(int head, IntNode next) {
        this.head = head;
        this.next = next;
    }
    public int length() {
        IntNode current = this;
        int count = 0;

        while (current != null) { // at the end?
            count++; // += 1;
            current = current.next; // move to the next node
        }
        return count;
    }
    public String toString() {
        if (this.next == null) {
            return Integer.toString(this.head);
        }
        else {
            return Integer.toString(this.head) + ", " + this.next.toString();
        }
    }
}

public class Lecture3 {
    public static void main(String[] args) {
        /*
        IntNode list = null;
        list = new IntNode(9, list);
        list = new IntNode(11, list);
        list = new IntNode(7, list);

         */

        IntNode list0 = null;
        IntNode list1 = new IntNode(9, list0);
        IntNode list2 = new IntNode(11, list1);
        IntNode list3 = new IntNode(7, list2);
        System.out.println(list3.length());

        /*
        IntNode list = new IntNode();
        list.head = 7;
        list.next = new IntNode();
        list.next.head = 11;
        list.next.next = new IntNode();
        list.next.next.head = 9;
        list.next.next.next = null;
         */
    }

}