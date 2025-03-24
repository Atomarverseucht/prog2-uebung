package aufgabe1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author oliverbittel
 * @author Oliver Haase lul
 */
public class ArrayFrequencyTable extends AbstractFrequencyTable {
    private int size = 0;
    private List<Word> fqTable;
    private final static int DEFAULT_SIZE = 100;

    public ArrayFrequencyTable() {
        clear();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public final void clear() {
        // throw muss auskommentiert werden!
        // throw new UnsupportedOperationException("Not supported yet."); //To change
        // body of generated methods, choose Tools | Templates.
        // Ihr Code:
        fqTable.clear();
        size = 0;
    }

    @Override
    public void add(String w, int f) {
        for (Word word : fqTable) {
            if (word.getWord().equals(w)) {
                word.addFrequency(f);
                return;
            }
        }
        fqTable.add(new Word(w, f));
        size++;
    }

    private void moveToLeft(int pos) {
        Word w = fqTable[pos];
        int i = pos - 1;
        while (get(i).getFrequency() < get(pos).getFrequency()) {
            fqTable[i + 1] = fqTable[i];
            i++;
        }
        fqTable[i + 1] = w;
    }

    @Override
    public Word get(int pos) {
        return fqTable.get(pos);
    }

    @Override
    public int get(String w) {
        for (Word word : fqTable) {
            if (word.getWord().equals(w)) {
                return word.getFrequency();
            }
        }
    }

    @Override
    public void sort() {
        fqTable.sort(Comparator.naturalOrder());
        System.out.println(fqTable.toString());
    }
}
