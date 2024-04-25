import java.util.Arrays;

public class MinMax {
    public static void main(String[] args) {
        int[] nice = {1,1,1,1};
        System.out.println(minMaxAverage(nice));
    }

    public static double minMaxAverage(int[] numbers) {
        int myMin = numbers[0];
        int myMax = numbers[0];

        if (numbers.length > 1) {
            int[] minArray = new int[(numbers.length+1)/2];
            int[] maxArray = new int[(numbers.length+1)/2];
            int run = 0;

            for (int i = 0; i<numbers.length; i+=2) {
                if (i == numbers.length-1) {
                    minArray[minArray.length-1] = numbers[i];
                    maxArray[maxArray.length-1] = numbers[i];
                }
                else {
                    if (numbers[i] > numbers[i+1]) {
                        minArray[run] = numbers[i+1];
                        maxArray[run] = numbers[i];
                    }
                    else {
                        minArray[run] = numbers[i];
                        maxArray[run] = numbers[i+1];
                    }
                    run++;
                }
            }

            while (minArray.length != 1) {
                int index = 0;
                for (int i=0; i<minArray.length-1; i+=2) {
                    if (i == minArray.length-1) {
                        minArray[index] = minArray[i];
                        maxArray[index] = maxArray[i];
                    }
                    else {
                        if (minArray[i] > minArray[i+1])
                            minArray[index] = minArray[i+1];
                        else
                            minArray[index] = minArray[i];
                        if (maxArray[i] < maxArray[i+1])
                            maxArray[index] = maxArray[i+1];
                        else
                            maxArray[index] = maxArray[i];
                    }
                    index++;
                }
                int size = (minArray.length+1)/2;
                minArray = Arrays.copyOf(minArray, size);
                maxArray = Arrays.copyOf(maxArray, size);
            }
            myMin = minArray[0];
            myMax = maxArray[0];
        }

        return (myMin + myMax)/2.0;
    }
}
/*
My code uses fewer than 3n/2 comparisons because it implements the pair system.
First it splits the original list into two separate lists, one that contains the higher numbers between pairs and one that contains the lower numbers, it compares 2 numbers each time.
So, the first part makes the list of numbers go through n/2 comparisons.
Then, the second part is a while loop that keeps dividing both lists by 2, until only 1 number remains in each list.
And the last remaining number for each list is the min and max of the original list.
 */