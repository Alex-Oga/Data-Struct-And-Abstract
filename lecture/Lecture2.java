import java.util.Arrays;

public class Lecture2 {
    public static void main(String[] args) {
        int[] numbers = {3, 1, 4, 2, 8};

        // for-each (similar to Python)
        for (int num: numbers) {
            System.out.println(num);
        }

        // while
        int index = 0;
        while (index < numbers.length) {
            System.out.println(numbers[index]);
            index++; // index += 1;
        }
        // <- index? VISIBLE & AlIVE
        // C-for
        for (int i=0; i< numbers.length; i++) {
            System.out.println(numbers[i]);
        }
        // <- i? NOT VISIBLE & NOT ALIVE

        System.out.println(numbers); // prints the location of the array
        System.out.println(Arrays.toString(numbers)); // prints the content of the array

        // HOW TO COPY?
        int[] copy = numbers; // What does this do? Copies the pointer
        int[] realCopy = Arrays.copyOf(numbers, numbers.length); // Copies the content

        int n = 10_000_000 * 2 / 5;
        long[] a = new long[n];

    }

    public static int maxFullFor(int[] numbers) {
        int maxSoFar = numbers[0];
        for (int i=1; i<numbers.length; i++) {
            if (numbers[i] > maxSoFar) {
                maxSoFar = numbers[i];
            }
        }
        return maxSoFar;
    }
}
