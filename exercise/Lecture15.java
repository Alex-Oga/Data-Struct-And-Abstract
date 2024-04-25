import java.util.Arrays;
import java.util.Comparator;

public class Lecture15<T extends Comparable<T>>{

     int compare(T o1, T o2) {
        if (o1.compareTo(o2) < 0) {
            return -1;
        }
        if (o1.compareTo(o2) > 0) {
            return 1;
        }
        else
            return 0;
    }

    static <T> void insertionSort(T[] array, Comparator<T> cc) {
        int n = array.length;
        for (int i=1; i<n; i++) {
            T elt = array[i];
            int j = i;
            while (j>0 && cc.compare(elt, array[j-1]) < 0) {
                array[j] = array[j-1];
                j--;
            }
            array[j] = elt;
        }
    }

    static <T> void quickSort(T[] array, Comparator<T> cc) {

    }

    static <T> void mergeSort(T[] array, Comparator<T> cc) {
        int n = array.length;
        if (n <= 1)
            return;
        T[] left = Arrays.copyOfRange(array, 0, n/2);
        T[] right = Arrays.copyOfRange(array, n/2, n);



    }


    }
