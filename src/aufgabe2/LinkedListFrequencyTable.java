package aufgabe2;

import aufgabe1.AbstractFrequencyTable;
import aufgabe1.Word;

public class LinkedListFrequencyTable extends AbstractFrequencyTable {
    private int size = 0;
    private Node begin;
    private Node end;

    public class Node {
        private Node previous;
        private Node next;

        private Word data;

        Node(Node n, Node p, Word w) {
            next = n;
            previous = p;
            data = w.copy();
        }

        Word data() {
            return new Word(data.getWord(), data.getFrequency());
        }

        void addFrequency(int f) {
            data.addFrequency(f);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        begin = new Node(null, null, null);
        end = new Node(null, null, begin);
        begin.next = end;
        size = 0;
    }

    @Override
    public void add(String w, int f) {
        if (f <= 0) {
            throw new IllegalArgumentException();
        }
        Node p = begin;
        for (int i = 0; i < size; i++) {
            p = p.next;
            if (p.data.getWord().equals(w)) {
                p.data.addFrequency(f);
                moveToLeft(p);
                return;
            }
        }
        Node pre = end.previous;
        Word newWord = new Word(w, f);
        Node newNode = new Node(pre, end, newWord);
        pre.next = newNode;
        end.previous = newNode;
        size++;
        moveToLeft(p);
    }

    public void moveToLeft(Node p) {
        int f = p.data.getFrequency();
        Word w = p.data;
        for (int i = 0; i < size; i++) {
            if (p.previous != null && p.previous.data.getFrequency() >= f) {
                p.data = w;
            } else {
                p.data = p.previous.data;
                p = p.previous;
            }
        }
    }

    @Override
    public Word get(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node p;
        if (pos < size / 2) {
            p = begin;
            int i;
            for (i = 0; i <= pos; i++) {
                p = p.next;
            }
            if (i == pos) {
                return p.data;
            }
        } else {
            p = end;
            int i;
            for (i = 0; i <= size - pos; i++) {
                p = p.previous;
            }
            return p.data;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public int get(String f) {
        return 0;
    }
}
