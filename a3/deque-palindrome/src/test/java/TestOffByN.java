import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestOffByN {

    static CharacterComparator offByN = new OffByN(5);

    @Test
    public void testOffByN() {
        Boolean a = offByN.equalChars('a', 'f');
        assertEquals(true, a);
        Boolean b = offByN.equalChars('f', 'a');
        assertEquals(true, b);
        Boolean c = offByN.equalChars('f', 'h');
        assertEquals(false, c);
    }
}
