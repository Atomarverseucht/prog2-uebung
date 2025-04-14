package aufgabe2;

import aufgabe1.AbstractFrequencyTable;
import aufgabe1.Word;

public class LinkedListFrequencyTable<T> extends AbstractFrequencyTable<T> {
    private int size = 0;
    private Node begin;
    private Node end;

    public LinkedListFrequencyTable(){
        begin = new Node(null, null, null);
        end = new Node(null, begin, null);
        begin.next = end;
    }
    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        begin = new Node(null, null, null);
        end = new Node(null, begin, null);
        begin.next = end;
        size = 0;
    }

    @Override
    public void add(T w, int f) {
        if (f <= 0 && w == null) {
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
        Node newNode = new Node(end, pre, newWord);
        pre.next = newNode;
        end.previous = newNode;
        size++;
        moveToLeft(newNode);
    }

    public void moveToLeft(Node p) {
        //if(p.previous.data == null){return;}
        Word w = p.data;
        while (p.previous.data != null && p.previous.data.getFrequency() < w.getFrequency()) {
            p.data = p.previous.data;
            p = p.previous;
        }
        p.data = w;
    }

    @Override
    public Word get(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node p;
        if (pos < size / 2) {
            p = begin;
            for (int i = 0; i <= pos; i++) {
                p = p.next;
            }
            return p.data;
        } else {
            p = end;
            for (int i = 0; i < size - pos; i++) {
                p = p.previous;
            }
            return p.data;
        }
    }

    @Override
    public int get(T f) {
        Node p = begin;
        for (int i = 0; i < size; i++) {
            p = p.next;
            if (p.data != null && p.data.getWord().equals(f)) {
                return p.data.getFrequency();
            }
        }
        return 0;
    }

    private static class Node {
        private Node previous;
        private Node next;

        private Word data;

        Node(Node next, Node prev, Word w) {
            this.next = next;
            previous = prev;
            data = w;
        }
    }
}
