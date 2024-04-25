public class inter {

    public static void main(String[] args) {
        int[] num = {4, 2, 7, 9};
        int[] den = {2, 5, 0};

        for (int i=0; i<num.length; i++) {
            try {
                System.out.println("D" + num[i]/den[i]);
            }
            catch (ArithmeticException e) {
                System.out.println("Cant");
            }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("No");
            }
        }
        System.out.println("Done");
    }

}