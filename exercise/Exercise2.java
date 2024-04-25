import java.math.BigInteger;

public class Exercise2 {

    public static int numTrailingZeros(int n) {
        int sum = 0;
        BigInteger fac =BigInteger.ONE;

        for (int k=1; k<=n; k++) {
            fac = fac.multiply(BigInteger.valueOf((long)k));
        }

        String facStr = fac+"";
        char[] facCArray = facStr.toCharArray();

        for (int i=facCArray.length-1; i>=0; i--) {
            if (facCArray[i] == '0') {
                sum++;
            }
            else {
                break;
            }
        }
        return sum;
    }

    public static void windowPosSum(int[] a, int n) {
        int[] b = new int[a.length];

        for (int i=0; i<a.length; i++) {
            if (a[i] < 0) {
                b[i] = a[i];
            }
            else {
                if (i+n < a.length) {
                    for (int k=i; k<=i+n; k++) {
                        b[i] += a[k];
                    }
                }
                else {
                    for (int k=i; k<a.length; k++) {
                        b[i] += a[k];
                    }
                }
            }
        }
    }
}
