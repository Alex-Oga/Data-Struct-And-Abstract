public class Lecture18<E> {

    class Node<E> {
        E key;
        Node<E> left, right;
    }

    int depth(Node<E> r) {
        if (r == null)
            return 0;
        return 1+ Math.max(depth(r.left), depth(r.right));
    }
}
