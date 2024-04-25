import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestLast {

    @Test
    public void testLast() {
        int[] testA = {1, 2, 2, 2, 4, 5};
        Integer a = Last.binarySearchLast(testA, 2);
        assertEquals(3, a);
        int[] testB = {1, 2, 2, 2, 4, 5};
        Integer b = Last.binarySearchLast(testA, 0);
        assertEquals(null, b);
        int[] testC = {1, 2, 2, 2, 4, 5};
        Integer c = Last.binarySearchLast(testA, 5);
        assertEquals(5, c);


    }
}
