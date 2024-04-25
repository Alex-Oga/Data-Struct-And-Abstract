public class UsefulNumbers {
    public static void main(String[] args) {
        long secondsInAMinute = 60;
        long secondsInAnHour = secondsInAMinute*60;
        long secondsInADay = secondsInAnHour*24;
        long secondsInAYear = secondsInADay*365;
        long secondsInACentury = secondsInAYear*100;
        System.out.printf("One century contains %d seconds. \n", secondsInACentury);
    }
}
