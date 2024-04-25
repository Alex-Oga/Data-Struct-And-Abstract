public class Last {

    public static Integer binarySearchLast(int[] a, int k) {
        int index = 0;
        while (a.length != 1) {
            if (a[(a.length/2)-1] == k && a[a.length/2] != k)
                return (a.length/2)-1 + index;
            if (a[a.length/2] == k && a.length/2 == a.length-1)
                return a.length/2 + index;

            int[] b = new int[a.length-(a.length/2)];
            if (a[(a.length/2)-1] > k) {
                System.arraycopy(a, 0, b, 0, a.length-(a.length/2));
            }
            if (a[a.length/2] <= k) {
                index += a.length/2;
                System.arraycopy(a, a.length/2, b, 0, a.length-(a.length/2));
            }
            a = b;
        }

        if (a[0] == k)
            return 0;
        else
            return null;
    }
    /**
    1) Divide the list by 2
     2) Check (a.length/2)-1 and a.length/2
     2.1) if (a.length/2)-1 == last value of k, return (a.length/2)-1
     2.2) if a[(a.length/2)-1] is bigger than k, sublist and redo
     2.3) if a[a.length/2] is smaller than k, sublist and red
     2.4) if a.length/2 == a.length-1
     2.4.1) if a[a.length/2] != k, return null
     */

    public static void main(String[] args) {
        int[] test = {1,2,2,2,4,5};
        System.out.println(binarySearchLast(test, 2));
    }
}
