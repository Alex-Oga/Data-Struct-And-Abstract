package game;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

// HINT(s):
//   To read from src/resources/<filename>
//   InputStream is = getClass().getClassLoader().getResourceAsStream(filename);

public class WordDatabase implements IDatabase {
    private List<String> database;

    public WordDatabase(String filename) throws FileNotFoundException {
        InputStream is = null;
        try {
            is = getClass().getClassLoader().getResourceAsStream(filename);
            BufferedReader r = new BufferedReader(new InputStreamReader(is));
            while (r.readLine() != null) {
                database.add(r.readLine());
            }
        }
        catch (IOException e) {
            throw new FileNotFoundException();
        }
        finally {
            if (is != null) {
                try {
                    is.close();
                }
                catch (IOException e) {
                    throw new FileNotFoundException();
                }
            }
        }

    }

    @Override
    public void add(Word w) {
        database.add(w.getWord());
    }

    @Override
    public void remove(Word w) {
        if (database.contains(w.getWord()))
            database.remove(w.getWord());
    }

    @Override
    public List<Word> getWordWithLength(int l) {
        List<Word> returnList = new ArrayList<>();
        for (String i: database) {
            Word test = new Word(i);
            if (i.length() == l) {
                returnList.add(test);
            }
        }
        return returnList;
    }

    @Override
    public List<Word> getAllSubWords(Word w, int minLen) {
        List<Word> returnList = new ArrayList<>();
        for (String i: database) {
            Word test = new Word(i);
            if (i.length() >= minLen && test.canForm(w))
                returnList.add(test);
        }
        return returnList;
    }

    @Override
    public boolean contains(Word o) {
        for (String i: database) {
            Word test = new Word(i);
            if (test.equals(o))
                return true;
        }
        return false;
    }
}
