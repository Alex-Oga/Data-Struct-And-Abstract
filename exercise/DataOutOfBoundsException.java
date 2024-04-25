public class DataOutOfBoundsException extends Exception{
    public DataOutOfBoundsException(String dataName) {
        super("Data value " + dataName + " is out of bounds.");
    }
}
