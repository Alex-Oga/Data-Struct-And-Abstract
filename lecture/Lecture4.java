public class Lecture4 {
    class IntNode {
        int head;
        IntNode next;

        public IntNode(int head, IntNode next) {
            this.head = head;
            this.next = next;
        }
    }

    class SLList {
        // private IntNode first;
        private IntNode sen;
        private int size;

        public SLList() {
            size = 0;
            sen = new IntNode(-1, null);
        }

        public void addFirst(int x) {
            //first = new IntNode(x, first);
            sen.next = new IntNode(x, null);
            size++;
        }

        public void addLast(int x) {
            IntNode p = sen;
            while (p.next != null) {
                p = p.next;
            }

            p.next = new IntNode(x, null);
            size++;
        }

        public int getFirst() {
            // return first.head;
            return sen.next.head;
        }

        public int size() {
            return size;
        }
    }
}