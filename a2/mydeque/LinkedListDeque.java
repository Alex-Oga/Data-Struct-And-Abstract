public class LinkedListDeque<T> {

    class Node {
        T head;
        Node next;
        Node previous;

        public Node(T h, Node r, Node l) {
            head = h;
            next = r;
            previous = l;
        }
    }
    Node firstSen = new Node(null, null, null);
    Node lastSen = new Node(null, null, null);
    int size = 0;

    public LinkedListDeque() {
        firstSen.next = lastSen;
        lastSen.previous = firstSen;
    }
    public LinkedListDeque(LinkedListDeque<T> other) {
        Node p = other.firstSen;
        Node current = this.firstSen;
        while (p != null) {
            p = p.next;
            current.next = new Node(p.head, current.next, current);
            lastSen.previous = current.next;
            size++;
        }
    }

    public void addFirst(T item) {
        firstSen.next = new Node(item, firstSen.next, firstSen);
        if (lastSen.previous == firstSen)
            lastSen.previous = firstSen.next;
        size++;
    }
    public void addLast(T item) {
        lastSen.previous = new Node(item, lastSen, lastSen.previous);
        if (firstSen.next == lastSen)
            firstSen.next = lastSen.previous;
        size++;
    }
    public boolean isEmpty() {
        if (firstSen.next != lastSen)
            return false;
        return true;
    }
    public int size() {
        return size;
    }
    public String toString() {
        String str = "";
        Node current = firstSen.next;
        while (current.head != null) {
            str += current.head+" ";
            current = current.next;
        }
        return str;
    }
    public T removeFirst() {
        T returnitem;
        size--;
        if (firstSen.next == lastSen) {
            return null;
        }
        else if (firstSen.next.next == lastSen){
            returnitem = firstSen.next.head;
            firstSen.next = lastSen;
            lastSen.previous = firstSen;
            return returnitem;
        }
        else {
            returnitem = firstSen.next.head;
            firstSen.next = firstSen.next.next;
            return returnitem;
        }
    }
    public T removeLast() {
        T returnitem;
        size--;
        if (lastSen.previous == firstSen) {
            return null;
        }
        else if (lastSen.previous.previous == firstSen) {
            returnitem = lastSen.previous.head;
            lastSen.previous = firstSen;
            firstSen.next = lastSen;
            return returnitem;
        }
        else {
            returnitem = lastSen.previous.head;
            lastSen.previous = lastSen.previous.previous;
            return returnitem;
        }
    }
    public T get(int index) {
        Node current = this.firstSen.next;
        int counter = 0;

        while (current != null) {
            if (counter == index) {
                return current.head;
            }
            counter++;
            current = current.next;
        }
        return null;
    }
    public void printDeque() {
        System.out.println(this.firstSen);
    }

}
