public class AllCaps {

    public static int[] allCapLocations(String st) {
        char [] charSt = st.toCharArray();
        int size = 0;
        for (char i: charSt) {
            if (Character.isUpperCase(i))
                size++;
        }
        int [] intArray = new int[size];
        int index = 0;
        int index2 = 0;
        for (char i: charSt) {
            if (Character.isUpperCase(i)) {
                intArray[index2] = index;
                index2++;
            }
            index++;
        }
        return intArray;
    }

    public static void main(String[] args) {
        System.out.println(allCapLocations("a@bAaCt99q"));
        System.out.println(allCapLocations("@82968*%(*@^ttt)"));
        System.out.println(allCapLocations("PQRssssS"));
    }

}
