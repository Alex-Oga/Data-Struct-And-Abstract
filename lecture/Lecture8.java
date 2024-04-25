public class Lecture8 {
    class DataOutOfBoundsException extends Exception {
        public DataOutOfBoundsException(String dataName) {
            super("Data value" + dataName + " is out of bounds.");
        }
    }
    void setAge(int age) throws DataOutOfBoundsException{
        if (age <= 0 || age >= 200) {
            throw new DataOutOfBoundsException("age");
        }
    }
    public static void main(String[] args) {
        try {
            Lecture8 l = new Lecture8();
            // wrap in try-catch
            l.setAge(250);
        }
        catch (Exception e) {

        }
    }
}
