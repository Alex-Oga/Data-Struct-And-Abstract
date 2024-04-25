public class OffByN implements CharacterComparator{
    int offBy;
    public OffByN(int N) {
        offBy = N;
    }
    public boolean equalChars(char x, char y) {
        if (Character.getNumericValue(x) + offBy == Character.getNumericValue(y) || Character.getNumericValue(x) - offBy == Character.getNumericValue(y))
            return true;
        else if (Character.getNumericValue(y) + offBy == Character.getNumericValue(x) || Character.getNumericValue(y) - offBy == Character.getNumericValue(x))
            return true;
        else
            return false;
    }
}