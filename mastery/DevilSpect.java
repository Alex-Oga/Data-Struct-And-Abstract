import java.util.Arrays;

public class DevilSpect {

    public static String size(int k) {
        String length = "";
        long size = 0;
        int count = 0;
        while (count != k) {
            size += 7*7;
            count++;
        }
        return size+length;
    }
    public static int[] spectrum(int k) {
        int[] list = new int[size(k).length()];
        return null;
    }

    public static void main(String[] args) {
        int[] testCases = { 7, 99, 123, 208, 1502};
        int[][] expectedAnswers = {
                {0, 0, 1, 2, 1, 1, 0, 0, 1, 0},
                {10, 4, 11, 8, 9, 13, 7, 6, 9, 7},
                {9, 12, 9, 13, 11, 9, 9, 9, 13, 10},
                {15, 31, 16, 14, 17, 19, 17, 18, 12, 17},
                {127, 132, 129, 110, 142, 148, 119, 129, 122, 112}
        };
        for (int index=0; index<testCases.length; index++) {
            int[] yourAnswer = spectrum(testCases[index]);
            System.out.printf("tease(%d) ==> %s", testCases[index], Arrays.toString(yourAnswer));
            String verdict = Arrays.equals(expectedAnswers[index], yourAnswer)?"ok":"nope";
            System.out.printf(" -- [%s]\n", verdict);
        }
        /*
        System.out.println(Arrays.toString(tease(7))); // [0, 0, 1, 2, 1, 1, 0, 0, 1, 0]
        System.out.println(Arrays.toString(tease(99))); // [10, 4, 11, 8, 9, 13, 7, 6, 9, 7]
        System.out.println(Arrays.toString(tease(123))); // [9, 12, 9, 13, 11, 9, 9, 9, 13, 10]
        System.out.println(Arrays.toString(tease(208))); // [15, 31, 16, 14, 17, 19, 17, 18, 12, 17]
        System.out.println(Arrays.toString(tease(1502))); // [127, 132, 129, 110, 142, 148, 119, 129, 122, 112]
         */
    }
}
