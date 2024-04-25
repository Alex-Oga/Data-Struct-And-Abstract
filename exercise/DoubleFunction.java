import java.util.function.*;

public class DoubleFunction implements IntUnaryFunction{

    public int apply(int x) {
        return 2 * x;
    }

    int twice(IntUnaryFunction f, int x) {
        return f.apply(f.apply(x));
    }

    public static void main(String[] args) {
        DoubleFunction a = new DoubleFunction();
        System.out.println(a.twice(new DoubleFunction(), 5));
    }
}

class HoFDemoJava8 {

    static int doubleFunc(int x) {
        return 2 * x;
    }

    static int twice(Function<Integer, Integer> f, int x) {
        return f.apply(f.apply(x));
    }

    public static void main(String[] args) {
        int result = twice(HoFDemoJava8::doubleFunc, 4);
        System.out.println(result);
    }
}

class Maximum <T>{
    static<T> int maxIndex(T[] items, BiFunction<T, T, Boolean> isLarger) {
        if (items.length == 0) {
            return -1;
        }
        int maxIndex = 0;
        for (int index=0; index<items.length; index++) {
            if (isLarger.apply(items[index], items[maxIndex]))
                maxIndex = index;
        }
        return maxIndex;
    }
}

class MaxDem {
    static boolean isLargerByWeight(Cat x, Cat y) {
        return x.getWeight() > y.getWeight();
    }

    public static void main(String[] args) {
        Cat a = new Cat("Bob", 2, 1);
        Cat b = new Cat("Sock", 3, 1);
        Cat[] items = new Cat[2];
        items[0] = a;
        items[1] = b;
        Maximum c = new Maximum();
        int sampleRet = c.maxIndex(items, MaxDem::isLargerByWeight);
        System.out.println(sampleRet);
        int sampleRet2 = c.maxIndex(items, (Cat x, Cat y) -> x.getWeight() > y.getWeight());
        System.out.println(sampleRet2);
    }
}

class Max {
    static<T extends HasIsLarger<T>> int maxIndex(T[] items) {
        if (items.length == 0) {
            return -1;
        }
        int maxIndex = 0;
        for (int index=0; index< items.length; index++) {
            if (items[index].isLargerThan(items[maxIndex]))
                maxIndex = index;
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        Max a = new Max();
        Cat b = new Cat("Bob", 2, 1);
        Cat c = new Cat("Sock", 3, 1);
        Cat[] items = new Cat[2];
        items[0] = b;
        items[1] = c;
        System.out.println(a.maxIndex(items));
    }
}