import java.math.BigInteger;

public class Fib {

    public static int firstNDigit(int n) {
        BigInteger fibo = BigInteger.ONE, fibo2 = BigInteger.ZERO, fibo3 = BigInteger.ZERO;
        int index = 1;
        String len = "1";

        while (len.length() != n) {
            index++;
            fibo3 = fibo.add(fibo2);
            len = fibo3+"";
            fibo2 = fibo;
            fibo = fibo3;
        }
        return index;
    }
}
