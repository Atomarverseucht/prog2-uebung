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
        moveToLeft(p);
        size++;
    }
    public void moveToLeft(Node p) {

    }

    @Override
    public int get(String f) {
        return 0;
    }

    @Override
    public Word get(int pos) {
        return begin.data();
    }
}
