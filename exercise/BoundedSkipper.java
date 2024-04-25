import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;

public class BoundedSkipper implements Iterable<Integer> {
    private List<Integer> items;
    int length = 0;

    public BoundedSkipper(int k, int n) {
        items = new ArrayList<>();
        int num = 1;
        while (length != n) {
            String strNum = num+"";
            String strK = k+"";
            if (num % k != 0 && strNum.contains(strK) == false) {
                items.add(num);
                length++;
            }
            num++;
        }
    }

    public int size() { return items.size();}

    @Override
    public Iterator<Integer> iterator() {return new BoundedSkipperIterator(); }

    private class BoundedSkipperIterator implements Iterator<Integer> {
        private int where;
        public BoundedSkipperIterator() { where = 0; }

        @Override
        public boolean hasNext() {
            return where < length;
        }

        @Override
        public Integer next() {
            Integer intReturn = items.get(where);
            where++;
            return intReturn;
        }
    }
}