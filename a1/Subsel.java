import java.util.Arrays;

public class Subsel {

    public static int[] takeEvery(int[] a, int stride, int beginWith) {
        int[] b = new int[a.length];
        int cycle = 0;

        if (stride > 0) {
            for (int i=beginWith; i<a.length; i+=stride) {
                b[cycle] = a[i];
                cycle ++;
            }
        }
        else {
            for (int i=beginWith; i>=0; i += stride) {
                b[cycle] = a[i];
                cycle++;
            }
        }
        int[] newA = Arrays.copyOf(b, cycle);

        return newA;
    }

    public static int[] takeEvery(int[] a, int stride) {
        return takeEvery(a, stride, 0);
    }
}
