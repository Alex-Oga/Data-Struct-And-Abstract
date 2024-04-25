/* IMPORTANT: Uncomment this file after you're done with the Deque interface and wordToDeque
 */
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
 

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static CharacterComparator cc = new OffByOne();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }
    @Test
    public void testIsPalindrome() {
        Boolean a = palindrome.isPalindrome("Nice");
        assertEquals(false, a);
        Boolean b = palindrome.isPalindrome("noon");
        assertEquals(true, b);
        Boolean c = palindrome.isPalindrome("NiN");
        assertEquals(true, c);


        Boolean e = palindrome.isPalindrome("flake", cc);
        assertEquals(true, e);
        Boolean f = palindrome.isPalindrome("a", cc);
        assertEquals(true, f);
        Boolean g = palindrome.isPalindrome("", cc);
        assertEquals(true, g);
        Boolean h = palindrome.isPalindrome("az", cc);
        assertEquals(false, h);
        Boolean i = palindrome.isPalindrome("iacgdbj", cc);
        assertEquals(true, i);
    }
}

