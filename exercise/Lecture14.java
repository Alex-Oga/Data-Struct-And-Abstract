import java.util.Arrays;

public class Lecture14 {

    public static int linearSearch(String[] array, String targetKey) {
        for (int i=0; i<array.length; i++) {
            if (array[i].equals(targetKey))
                return i;
        }
        return -1;
    }

    public static int binarySearch(String[] array, String targetKey) {
        if (array.length == 0)
            return -1;

        int m = array.length/2;

        if (array[m].equals(targetKey))
            return m;
        if (targetKey.length() < array[m].length()) {
            return binarySearch(Arrays.copyOfRange(array, 0, m), targetKey);
        }

        int r = binarySearch(Arrays.copyOfRange(array, m+1, array.length), targetKey);
        if (r < 0) {
            return -1;
        }
        else {
            return m + 1 + r;
        }
    }

    public static void main(String[] args) {
        String[] array = {"ab", "bex", "def", "ccc"};
        System.out.println(linearSearch(array, "ccc"));
        System.out.println(binarySearch(array, "ccc"));
    }
}
/**
 * primSum
 * Runs in O(1) in the best case and o(log N) in the worst case
 *
 * whazIt
 * Runs in O(n^2)
 */
