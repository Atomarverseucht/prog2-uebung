package aufgabe2;

import aufgabe1.AbstractFrequencyTable;
import aufgabe1.Word;

public class LinkedListFrequencyTable extends AbstractFrequencyTable {
    private int size = 0;
    private Node begin;
    private Node end;

    @Override
    public int size(){
        return size;
    }

    @Override
    public void clear(){
        begin.next = end;
    }

    @Override
    public void add(String w, int f){
    }

    @Override
    public int get(String f){
        return 0;
    }

    @Override
    public Word get(int pos){
        return begin.data();
    }
    public class Node{
        private Node previous;
        private Node next;

        private Word data;

        Node(Node n, Node p, Word w){
          next = n;
          previous = p;
          data = w.copy();
        }
        Word data(){
            return new Word(data.getWord(), data.getFrequency());
        }

        void addFrequency(int f){
            data.addFrequency(f);
        }
    }
}
