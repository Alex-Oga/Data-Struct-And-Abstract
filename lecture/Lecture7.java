import java.util.function.BiFunction;
interface HasIsLarger<T> {
    boolean isLargerThan(T that);
}
class Feline implements HasIsLarger<Feline>{
    Feline(int w, double h, String name) {
        this.w = w; height = h; this.name = name;
    }
    int w;
    double height;
    String name;

    public boolean isLargerThan(Feline that) {
        return this.w > that.w;
    }
}

interface IsLargerThanFunc<T> {
    boolean apply(T a, T b);
}

interface IsLongerThanFunc<T> {
    boolean apply(T c, T d);
}

class LargerThanByWeight implements IsLargerThanFunc<Feline> {
    public boolean apply(Feline a, Feline b) {
        return a.w > b.w;
    }
}

class LargerThanByName implements IsLongerThanFunc<Feline> {
    public boolean apply(Feline a, Feline b) {
        return a.name.length() > b.name.length();
    }
}

public class Lecture7 {

    static<T extends HasIsLarger<T>> int maxIndex(T[] items) {
        int maxDex = 0;
        for (int i=1; i < items.length; i++) {
            if (items[i].isLargerThan(items[maxDex]))
                maxDex = i;
        }
        return maxDex;
    }

    static <T> int maxIndex(T[] items, IsLargerThanFunc<T> isLargerThanFunc) {
        int maxDex = 0;
        for (int i=1; i<items.length; i++) {
            if (isLargerThanFunc.apply(items[i], items[maxDex])) {
                maxDex = i;
            }
        }
        return maxDex;
    }


    static int maxIndex(int[] items) {
        int index = 0;
        int max = items[0];
        for (int i=0; i<items.length; i++) {
            if (items[i] > max) {
                max = items[i];
                index=i;
            }
        }
        return index;
    }

    static boolean byNameLength(Feline a, Feline b) {
        return a.name.length() > b.name.length();
    }

    public static void main(String[] args) {
        Feline[] fls = {
                new Feline(5, 2.5, "Feline 1"),
                new Feline(2, 2.7, "Feline 2"),
                new Feline(7, 1.7, "Feline 3"),
                new Feline(4, 3.1, "Feline 4")
        };

        int ans = maxIndex(fls);
        System.out.println(ans);

        /*
        int ans = maxIndex(fls, Lecture7::byNameLength);
        int alsoAns = maxIndex(fls, (Feline a, Feline b) -> a.height > b.height);

        LargerThanByWeight isLargerThanByWt = new LargerThanByWeight();

        int maxDexByWeight = maxIndex(fls, isLargerThanByWt);
        int maxDexByNameLength = maxIndex(fls, new LargerThanByName());
        // System.out.println(maxIndex(new int[]{3, 1, 4, 1, 5, 2}));
        */
    }
}
