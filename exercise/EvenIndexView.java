import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIndexView<T> implements Iterable<T>{
    private T[] array;

    private class EvenIndexViewIter implements Iterator<T> {
        int index;
        public EvenIndexViewIter() { index = 1;}


        @Override
        public boolean hasNext() {
            return index < array.length;
        }

        @Override
        public T next() {

            if (index < array.length) {
                T retVal = array[index];
                index += 2;
                return retVal;
            }
            else {
                throw new NoSuchElementException();
            }
        }
    }

    public EvenIndexView(T[] array) {this.array = array;}

    @Override
    public Iterator<T> iterator() {
        return new EvenIndexViewIter();
    }

    public static void main(String[] args) {
        EvenIndexView<String> view = new EvenIndexView<>(new String[]{"ze", "ne", "wo", "boo", "ee"});
        for (String st: view) {
            System.out.println(st);
        }
    }
}
