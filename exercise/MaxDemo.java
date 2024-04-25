import java.util.*;
import java.util.function.BiFunction;

public class MaxDemo<T> {

    public interface HasIsLarger<T> {
        boolean isLargerThan(T that);
    }
    static <T> T maxValue(T[] items, BiFunction<T, T, Boolean> isLarger) {
        if (items.length == 0)
            return null;
        int maxIndex = 0;
        for (int index=0;index<items.length;index++) {
            if (isLarger.apply(items[index], items[maxIndex]))
                maxIndex = index;
        }
        return items[maxIndex];
    }

    static<T extends HasIsLarger<T>> T maxValue(T[] items) {
        if (items.length == 0)
            return null;
        int maxIndex = 0;
        for (int index=0;index<items.length;index++) {
            if (items[index].isLargerThan(items[maxIndex]))
                maxIndex = index;
        }
        return items[maxIndex];
    }
}
