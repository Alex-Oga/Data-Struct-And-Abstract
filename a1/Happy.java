public class Happy {

    public static long sumOfDigitsSquared(long n) {
        String numbers = n+"";
        long total = 0;

        for (int i=0; i<numbers.length(); i++) {
            total += Character.getNumericValue(numbers.charAt(i))*Character.getNumericValue(numbers.charAt(i));
        }

        return total;
    }

    public static boolean isHappy(long n) {
        long h = 0;

        while (n != 1 || n != 4) {
            n = sumOfDigitsSquared(n);
            if (n == 1) { break; }
            else if (n == 4) { break; }
        }

        if (n == 1) { return true; }
        else { return false; }
    }

    public static long[] firstK(int k) {
        long[] list = new long[k];
        long current = 1;
        int runner = 0;

        while (list[k-1] == 0) {
            if (isHappy(current) == true) {
                list[runner] = current;
                runner ++;
                current++;
            }
            else {
                current++;
            }
        }

        return list;
    }
}
