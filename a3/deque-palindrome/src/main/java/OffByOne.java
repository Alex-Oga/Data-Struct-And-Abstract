public class OffByOne implements CharacterComparator{
    public boolean equalChars(char x, char y) {
        if (Character.getNumericValue(x) + 1 == Character.getNumericValue(y) || Character.getNumericValue(x) - 1 == Character.getNumericValue(y))
            return true;
        else if (Character.getNumericValue(y) + 1 == Character.getNumericValue(x) || Character.getNumericValue(y) - 1 == Character.getNumericValue(x))
            return true;
        else
            return false;
    }
}