public class MultiplyAllButMe {

    public static Integer allButMe(int[] lst, int k) {
        Integer total = null;

        for (int i=0; i< lst.length; i++) {
            if (i == k) {
                continue;
            }
            else if (total == null) {
                total += lst[i];
            }
            else {
                total = total*lst[i];
            }
        }
        return total;
    }

    public static void main(String[] args) {
        int[] test = {2, 5, 0, 9};
        System.out.println(allButMe(test, 2));
    }
}
