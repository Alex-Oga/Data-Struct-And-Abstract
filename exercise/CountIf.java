public class CountIf<T> {
    Predicate<T> test;

    public CountIf(Predicate<T> pred) {
        test = pred;
    }

    public int count(T[] items) {
        int count = 0;
        for (T i: items) {
            if (test.test(i))
                count++;
        }
        return count;
    }

}