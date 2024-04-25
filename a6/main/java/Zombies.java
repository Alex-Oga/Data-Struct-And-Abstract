public class Zombies {

    public static int countBad(int[] hs) {
        int counter = 0;

        for (int i=0; i<hs.length-1; i++) {
            if (hs[i] < hs[i+1]) {
                counter++;
                int a = hs[i];
                int b = hs[i+1];
                hs[i] = b;
                hs[i+1] = a;

                return counter + countBad(hs);
            }
        }
        return counter;
    }
    /**
     * Recursion
     */
}
