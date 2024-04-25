public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> lst = new LinkedListDeque<>();
        for (char i: word.toCharArray()) {
            lst.addLast(i);
        }
        return lst;
    }
    public boolean isPalindrome(String word) {
        if (wordToDeque(word).equals(wordToReverse(word)))
            return true;
        return false;
    }
    public Deque<Character> wordToReverse(String word) {
        Deque<Character> lst = new LinkedListDeque<>();
        for (char i: word.toCharArray()) {
            lst.addFirst(i);
        }
        return lst;
    }
    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> lst = wordToDeque(word);
        Deque<Character> reverseLst = wordToReverse(word);
        if (word.length() <= 1)
            return true;
        for (int i=0; i<lst.size(); i++) {
            if (i != lst.size()/2) {
                if (cc.equalChars(lst.get(i), reverseLst.get(i)))
                    continue;
                else
                    return false;
            }
        }
        return true;
    }
}