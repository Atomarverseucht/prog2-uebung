package aufgabe1;

import java.util.Arrays;

/**
 *
 * @author oliverbittel
 * @author Oliver Haase
 */
public class ArrayFrequencyTable<T> extends AbstractFrequencyTable<T> {
    private int size = 0;
    private final static int DEFAULT_SIZE = 100;

    private Word[] fqTable = new Word[DEFAULT_SIZE];

    public ArrayFrequencyTable() {
        clear();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public final void clear() {
        fqTable = new Word[DEFAULT_SIZE];
        size = 0;
    }

    @Override
    public void add(T w, int f) {
        if(f<=0){
            throw new IllegalArgumentException();
        }
        if (fqTable.length == size) {
            fqTable = Arrays.copyOf(fqTable, 2 * size);
        }
        for (int i = 0; i < size; i++) {
            Word word = fqTable[i];
            if (word.getWord().equals(w)) {
                word.addFrequency(f);
                moveToLeft(i);
                return;
            }
        }
        fqTable[size] = new Word(w, f);
        moveToLeft(size);
        size++;
    }

    private void moveToLeft ( int pos){

        final Word w = fqTable[pos];
        int i = pos - 1;
        while (i >= 0 && get(i).getFrequency() < w.getFrequency()) {
            fqTable[i + 1] = fqTable[i]; i--;
        }
        fqTable[i + 1] = w;
    }

    @Override
    public Word get ( int pos){
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException();
        }
        return fqTable[pos];
    }

    @Override
    public int get (T w){
        for (Word word : fqTable) {
            if (word != null && word.getWord().equals(w)) {
                return word.getFrequency();
            }
        }
        return 0;
    }
}
