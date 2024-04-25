package game;

import histogram.Histogram;
import histogram.SimpleHistogram;

public class Word implements Formable<Word>, Comparable<Word> {
    private String word;
    private Histogram<Character> histogram;

    public Word(String word) {
        this.word = word;
        Character[] hist = new Character[word.length()];
        int count = 0;
        for (char i: word.toCharArray()) {
            hist[count] = Character.valueOf(i);
            count++;
        }
        histogram = new SimpleHistogram<>(hist);
    }
    public String getWord() {
        return word;
    }
    public Histogram<Character> getHistogram() {
        return histogram;
    }

    @Override
    public boolean canForm(Word other) {
        if (word.length() < other.word.length())
            return false;
        try {
            for (Character i: other.histogram) {
                if (histogram.getCount(i) != other.histogram.getCount(i))
                    return false;
            }
        }
        catch (NullPointerException e) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Word o) {
        if (word.length() < o.word.length())
            return -1;
        if (word.equals(o.word))
            return 0;
        if (word.length() == o.word.length()) {
            int totalThis = 0;
            int totalOther = 0;
            for (Character i: histogram) {
                totalThis += Character.getNumericValue(i);
            }
            for (Character i: o.histogram) {
                totalOther += Character.getNumericValue(i);
            }
            if (totalThis < totalOther)
                return -1;
        }
        return +1;
    }
}
