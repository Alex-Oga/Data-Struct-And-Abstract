public class Hidden {

    public static boolean isHidden(String s, String t) {
        int count = 0;
        int current = 0;

        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == t.charAt(current)) {
                count++;
                current ++;
            }
            if (count == t.length()) {
                break;
            }
        }

        if (count == t.length()) { return true; }
        else { return false; }

    }
}
