import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    // Your tests go here.
    @Test
    public void testEqualChars() {
        Boolean a = offByOne.equalChars('a', 'b');
        assertEquals(true, a);
        Boolean b = offByOne.equalChars('r', 'q');
        assertEquals(b, true);
        Boolean c = offByOne.equalChars('a', 'e');
        assertEquals(false, c);
        Boolean d = offByOne.equalChars('z', 'a');
        assertEquals(false, d);
        Boolean e = offByOne.equalChars('a', 'a');
        assertEquals(false, e);
    }
} 

