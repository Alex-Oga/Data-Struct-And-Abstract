import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestZombies {

    @Test
    public void testZombies() {
        int[] testA = {35, 22, 10};
        int a = Zombies.countBad(testA);
        assertEquals(0, a);
        int[] testB = {3, 1, 4, 2};
        int b = Zombies.countBad(testB);
        assertEquals(3, b);
        int[] testC = {5, 4, 11, 7};
        int c = Zombies.countBad(testC);
        assertEquals(4, c);
        int[] testD = {1, 7, 22, 13, 25, 4, 10, 34, 16, 28, 19, 31};
        int d = Zombies.countBad(testD);
        assertEquals(49, d);
    }
}
